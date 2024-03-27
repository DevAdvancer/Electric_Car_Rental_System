import java.sql.SQLException;
import java.util.Scanner;
import Authentication.*;

public class Main {
  static Scanner sc = new Scanner(System.in);

  static {
    System.out.println("=====|| Welcome to our Electric Car Rental System ||=====");
    System.out.println("=====|| Please Feel Comfortable using our System  ||======");
  }

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Authentication Auth = new Authentication();
    SignUp Sign = new SignUp();
    System.out.println("Choose to Login or Signup");
    System.out.println("1. Login");
    System.out.println("2. Signup");
    int option = sc.nextInt();
    switch (option) {
      case 1:
        System.out.println("Choose Option: ");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        int option1 = sc.nextInt();
        switch (option1) {
          case 1:
            Auth.admin();
            Auth.authenticationAdmin();
            break;
          case 2:
            Auth.customer();
            Auth.authenticationCustomer();
            break;
          default:
            System.out.println("Invalid Option");
            break;
        }
        break;
      case 2:
        Sign.signUp();
        Sign.addToSql();
        break;
      default:
        System.out.println("Invalid Option");
        break;
    }
  }
}