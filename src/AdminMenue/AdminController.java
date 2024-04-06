package AdminMenue;

import java.util.Scanner;
import java.sql.*;

public class AdminController {
  private final Scanner sc = new Scanner(System.in);
  private Connection con;

  public AdminController() {
    try {
      String url = "jdbc:mysql://localhost:3306/project";
      String uname = "root";
      String pass = "password";
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, uname, pass);
      createTableIfNotExists(); // Create table if not exists
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public void createTableIfNotExists() {
    try {
      String sql = "CREATE TABLE IF NOT EXISTS CAR (car_id INT AUTO_INCREMENT PRIMARY KEY, vehicleName VARCHAR(255))";
      Statement stmt = con.createStatement();
      stmt.execute(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void displayMenu() {
    System.out.println("Admin Menu:");
    System.out.println("1. Add Vehicle");
    System.out.println("2. Update Vehicle");
    System.out.println("3. Delete Vehicle");
    System.out.println("4. View Rentals");
    System.out.println("5. Exit");
    System.out.print("Enter your choice: ");
  }

  public void mainMenu() {
    boolean exit = false;
    while (!exit) {
      displayMenu();
      int choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1:
          addVehicle();
          break;
        case 2:
          updateVehicle();
          break;
        case 3:
          deleteVehicle();
          break;
        case 4:
          viewRentals();
          break;
        case 5:
          exit = true;
          System.out.println("Exiting...............");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  protected void addVehicle() {
    try {
      PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO CAR (vehicleName) VALUES (?)");
      System.out.print("Enter vehicle name: ");
      String vehicleName = sc.nextLine();
      preparedStatement.setString(1, vehicleName);
      int rowsInserted = preparedStatement.executeUpdate();
      if (rowsInserted > 0) {
        System.out.println("Vehicle added successfully!");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  protected void updateVehicle() {
    try {
      System.out.println("Enter the car ID to update:");
      int carId = sc.nextInt();
      sc.nextLine(); // Consume newline character
      System.out.print("Enter updated vehicle name: ");
      String updatedVehicleName = sc.nextLine();
      PreparedStatement preparedStatement = con.prepareStatement("UPDATE CAR SET vehicleName = ? WHERE car_id = ?");
      preparedStatement.setString(1, updatedVehicleName);
      preparedStatement.setInt(2, carId);
      int rowsUpdated = preparedStatement.executeUpdate();
      if (rowsUpdated > 0) {
        System.out.println("Vehicle updated successfully!");
      } else {
        System.out.println("No vehicle found with the provided ID.");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  protected void deleteVehicle() {
    try {
      System.out.println("Enter the car ID to delete:");
      int carId = sc.nextInt();
      PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM CAR WHERE car_id = ?");
      preparedStatement.setInt(1, carId);
      int rowsDeleted = preparedStatement.executeUpdate();
      if (rowsDeleted > 0) {
        System.out.println("Vehicle deleted successfully!");
      } else {
        System.out.println("No vehicle found with the provided ID.");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  protected void viewRentals() {
    try {
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT rc.car_id, rc.customer_id, c.customer_name, rd.start_date, rd.end_date FROM RentalCars rc INNER JOIN Customers c ON rc.customer_id = c.customer_id INNER JOIN RentalDates rd ON rc.rental_id = rd.rental_id");

      while (resultSet.next()) {
        System.out.println("Car ID: " + resultSet.getInt("car_id"));
        System.out.println("Customer Name: " + resultSet.getString("customer_name"));
        System.out.println("Start Date: " + resultSet.getDate("start_date"));
        System.out.println("End Date: " + resultSet.getDate("end_date"));
        // You can print other rental details as needed
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
