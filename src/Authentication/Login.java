package Authentication;

import java.util.Scanner;
import java.sql.*;

public class Login {
  private Connection con;

  public Login() {
    try {
      String url = "jdbc:mysql://localhost:3306/project";
      String uname = "root";
      String pass = "AbhirupKeya";
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, uname, pass);
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Database Connection Error !!! " + e.getMessage());
    }
  }

  Scanner sc = new Scanner(System.in);

  public void login() {
    System.out.print("Enter Username: ");
    String username = sc.nextLine().toLowerCase().replaceAll("\\s", "");
    System.out.print("Enter Password: ");
    String password = sc.nextLine();
    authenticate(username, password);
  }

  public void authenticate(String username, String password) {
    try {
      String sql = "SELECT * FROM CUSTOMER WHERE USERNAME = ? AND PASSWORD = ?";
      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, password);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        System.out.println("Login Successful.");
      } else {
        System.out.println("Authentication Failed. Username or Password is incorrect.");
      }
    } catch (SQLException e) {
      System.out.println("Database Query Execution Error !!! " + e.getMessage());
    }
  }
}
