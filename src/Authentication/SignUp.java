package Authentication;

import java.util.Scanner;
import java.sql.*;

public class SignUp {
  private Connection con;

  public SignUp() {
    try {
      String url = "jdbc:mysql://localhost:3306/project";
      String uname = "root";
      String pass = "AbhirupKeya";
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, uname, pass);
      createCustomersTableIfNotExists(); // Create table if not exists
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public void createCustomersTableIfNotExists() throws SQLException {
    String sql = "CREATE TABLE IF NOT EXISTS customer (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50), password VARCHAR(50), name VARCHAR(30))";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.execute();
  }

  Scanner sc = new Scanner(System.in);
  protected String UserName;
  protected String Password;

  public void signUp() {
    System.out.print("Username (username will be in lowercase without spaces): ");
    UserName = sc.nextLine().toLowerCase().replaceAll("\\s", "");
    System.out.print("Password: ");
    Password = sc.nextLine();
    System.out.println("Enter Name: ");
    String Name = sc.nextLine();
    addToSql(Name);
  }

  public void addToSql(String Name) {
    try {
      String sql = "INSERT INTO customers (username, password, name) VALUES (?, ?, ?)";
      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setString(1, UserName);
      stmt.setString(2, Password);
      stmt.setString(3, Name);
      stmt.executeUpdate();
      System.out.println("Successfully Signed Up.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
