package Authentication;

import java.util.Scanner;
import java.sql.*;

// Authentication System
public class Authentication {
  private Connection con;

  public Authentication() {
    try {
      String url = "jdbc:mysql://localhost:3306/project";
      String uname = "root";
      String pass = "AbhirupKeya";
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, uname, pass);
      createTableIfNotExists(); // Create table if not exists
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Database Connection Error !!!" + e.getMessage());
    }
  }

  public void createTableIfNotExists() throws SQLException {
    String sql = "CREATE TABLE IF NOT EXISTS ADMIN (ADMIN_ID INT AUTO_INCREMENT PRIMARY KEY, USERNAME VARCHAR(50), PASSWORD VARCHAR(50), NAME VARCHAR(30))";
    Statement stmt = con.createStatement();
    stmt.execute(sql);
  }

  public void admin(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Admin Username: ");
    String adminUserName = sc.next();
    System.out.print("Admin Password: ");
    String adminPassword = sc.next();
    authenticationAdmin(adminUserName, adminPassword);
  }

  public void authenticationAdmin(String username, String password) {
    try {
      String sql = "SELECT * FROM ADMIN WHERE USERNAME = ? AND PASSWORD = ?";
      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, password);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        System.out.println("Login Successful............");
      } else {
        System.out.println("Authentication Failed...............");
        System.exit(0);
      }
    } catch (SQLException e) {
      System.out.println("Database Query Execution Error !!! " + e.getMessage());
    }
  }
}
