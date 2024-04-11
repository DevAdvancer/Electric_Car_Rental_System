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
      e.printStackTrace();
    }
  }

  public void createTableIfNotExists() throws SQLException {
    String sql = "CREATE TABLE IF NOT EXISTS Admin (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50), password VARCHAR(50))";
    Statement stmt = con.createStatement();
    stmt.execute(sql);
  }

  public void admin() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Admin Username: ");
    String adminUserName = sc.nextLine();
    System.out.print("Admin Password: ");
    String adminPassword = sc.nextLine();
    authenticationAdmin(adminUserName, adminPassword);
  }

  public void authenticationAdmin(String username, String password) {
    try {
      String sql = "SELECT * FROM Admin WHERE username = ? AND password = ?";
      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, password);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        System.out.println("Login Successful.");
      } else {
        System.out.println("Authentication Failed.");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
