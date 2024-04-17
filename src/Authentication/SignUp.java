package Authentication;

import java.util.Scanner;
import java.sql.*;

public class SignUp {
  private Connection con;
  private Scanner sc;

  public String Name;
  public SignUp() {
    try {
      String url = "jdbc:mysql://localhost:3306/project";
      String uname = "root";
      String pass = "AbhirupKeya";
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, uname, pass);
      createCustomersTableIfNotExists(); // Create table if not exists
      sc = new Scanner(System.in);
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Database Connection Error !!! " + e.getMessage());
    }
  }

  public void createCustomersTableIfNotExists() {
    try {
      String sql = "CREATE TABLE IF NOT EXISTS CUSTOMER (Customer_ID INT AUTO_INCREMENT PRIMARY KEY, USERNAME VARCHAR(50), PASSWORD VARCHAR(50), NAME VARCHAR(30))";
      try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.execute();
      }
    } catch (SQLException e) {
      System.out.println("Error creating table: " + e.getMessage());
    }
  }

  public void signUp(){
    System.out.print("Username (username will be in lowercase without spaces): ");
    String userName = sc.next().toLowerCase().replaceAll("\\s", "");
    System.out.print("Password: ");
    String password = sc.next();
    System.out.print("Enter Name: ");
    sc.nextLine(); // Consume newline character
    String name = sc.nextLine();
    addToSql(userName, password, name);
  }

  public void addToSql(String userName, String password, String name) {
    try {
      String sql = "INSERT INTO CUSTOMER (USERNAME, PASSWORD, NAME) VALUES (?, ?, ?)";
      try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setString(1, userName);
        stmt.setString(2, password);
        stmt.setString(3, name);
        stmt.executeUpdate();
        System.out.println("Successfully Signed Up.");
        Name = name;
      }
    } catch (SQLException e) {
      System.out.println("Database Query Execution Error !!! " + e.getMessage());
    }
  }
}
