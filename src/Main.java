import java.io.IOException;
import java.util.*;
import Authentication.*;
import AdminMenue.*;
import java.sql.*;

public class Main {
  static Connection con = null;

  static Scanner sc = new Scanner(System.in);

  static {
    try {
      String url = "jdbc:mysql://localhost:3306/project";
      String uname = "root";
      String pass = "AbhirupKeya";
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, uname, pass);
    } catch (Exception e) {
      System.out.println("Database Connection Error !!! " + e.getMessage());
    }

    System.out.println("Initializing databases...............");

    System.out.println("=====|| Welcome to our Electric Car Rental System ||=====");
    System.out.println("=====|| Please Feel Comfortable using our System  ||======");
  }

  public static void main(String[] args){
    if (con != null) {
      System.out.println("DATABASE IS CONNECTED...............................");
      Authentication Auth = new Authentication();
      SignUp Sign = new SignUp();
      Login login = new Login();
      AdminController admin = new AdminController();

      System.out.println("Choose Admin or Customer");
      System.out.println("1. Admin");
      System.out.println("2. Customer");
      System.out.println("3. Exit");
      int option = sc.nextInt();
      switch (option) {
        case 1:
          Auth.admin();
          admin.mainMenu();
          break;
        case 2:
          System.out.println("Choose Option: ");
          System.out.println("1. Login");
          System.out.println("2. Signup");
          int option2 = sc.nextInt();
          switch (option2) {
            case 1:
              login.login();
              break;
            case 2:
              Sign.signUp();
              break;
            default:
              System.out.println("Invalid Option");
              break;
          }
          break;
        case 3:
          System.out.println("THANK YOU FOR USING OUR SYSTEM..........................");
          System.out.println("EXITING...............");
          System.exit(0);
        default:
          System.out.println("Invalid Option");
          break;
      }
    } else {
      System.out.println("ERROR CONNECTING TO DATABASE...!!!!!!");
    }
  }
}