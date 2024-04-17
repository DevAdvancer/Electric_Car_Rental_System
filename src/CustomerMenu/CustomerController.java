package CustomerMenu;

import java.util.Scanner;
import java.sql.*;

public class CustomerController {
  private final Scanner sc = new Scanner(System.in);
  private Connection con;
  private String Name;

  public void setName(String Name) {
    this.Name = Name;

  }

  public CustomerController() {
    try {
      String url = "jdbc:mysql://localhost:3306/project";
      String uname = "root";
      String pass = "AbhirupKeya";
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, uname, pass);
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println(e.getMessage());
    }


  }

  private void displayMenu() {
    System.out.println("Customer Menu........");
    System.out.println("Welcome, " + Name + "!");
    System.out.println("1. Rent Car");
    System.out.println("2. Registered Car");
    System.out.println("3. Rented History");
    System.out.print("Enter Choice: ");
  }

  public void mainMenu() {
    boolean exit = false;
    while (!exit) {
      displayMenu();
      int Choice = sc.nextInt();
      switch (Choice) {
        case 1:
          exit = true;
          System.out.println("Exiting...............");
          break;
        default:
          System.out.println("Invalid Choice Try Again...");
      }
    }
  }
}