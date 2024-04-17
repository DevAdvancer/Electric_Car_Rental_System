package Authentication;

import java.util.Scanner;
import java.sql.*;

public class Login {
  private Connection con;
  private Scanner sc;

  public String Name;
  public Login() {
    try {
      String url = "jdbc:mysql://localhost:3306/project";
      String uname = "root";
      String pass = "AbhirupKeya";
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, uname, pass);
      sc = new Scanner(System.in);
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Database Connection Error !!! " + e.getMessage());
    }
  }

  public void login() {
    try {
      System.out.print("Enter Username: ");
      String username = sc.next().toLowerCase().replaceAll("\\s", "");
      System.out.print("Enter Password: ");
      String password = sc.next();
      if (authenticate(username, password)) {
        String loggedUserName = getLoggedUserName(username);
        if (loggedUserName != null) {
          Name = loggedUserName;
        } else {
          System.out.println("Failed to retrieve user name.");
        }
      } else {
        System.out.println("Authentication failed.");
      }
    } catch (SQLException e) {
      System.out.println("Error during login: " + e.getMessage());
    }
  }

  private boolean authenticate(String username, String password) throws SQLException {
    String sql = "SELECT * FROM CUSTOMER WHERE USERNAME = ? AND PASSWORD = ?";
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      stmt.setString(1, username);
      stmt.setString(2, password);
      try (ResultSet rs = stmt.executeQuery()) {
        return rs.next();
      }
    }
  }

  private String getLoggedUserName(String username) throws SQLException {
    String name = null;
    String sql = "SELECT NAME FROM CUSTOMER WHERE USERNAME = ?";
    try (PreparedStatement stmt = con.prepareStatement(sql)) {
      stmt.setString(1, username);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          name = rs.getString("NAME");
        }
      }
    }
    return name;
  }
}
