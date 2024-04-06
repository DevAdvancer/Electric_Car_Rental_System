package Authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SignUp {
  private Connection con;

  public SignUp() {
    try {
      String url = "jdbc:mysql://localhost:3306/project";
      String uname = "root";
      String pass = "password";
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, uname, pass);
      createCustomersTableIfNotExists(); // Create table if not exists
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public void createCustomersTableIfNotExists() throws SQLException {
    String sql = "CREATE TABLE IF NOT EXISTS customers (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50), password VARCHAR(50))";
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
    addToSql();
  }

  public void addToSql() {
    try {
      String sql = "INSERT INTO customers (username, password) VALUES (?, ?)";
      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setString(1, UserName);
      stmt.setString(2, Password);
      stmt.executeUpdate();
      System.out.println("Successfully Signed Up.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    SignUp signUp = new SignUp();
    signUp.signUp(); // Call sign-up process
  }
}
