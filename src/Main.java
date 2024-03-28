import java.util.Scanner;
import Authentication.*;

public class Main {
  static Scanner sc = new Scanner(System.in);

  static {
    System.out.println("=====|| Welcome to our Electric Car Rental System ||=====");
    System.out.println("=====|| Please Feel Comfortable using our System  ||======");
  }

  public static void main(String[] args) {
    Authentication Auth = new Authentication();
    SignUp Sign = new SignUp();
    Login login = new Login();
    System.out.println("Choose Admin or Customer");
    System.out.println("1. Admin");
    System.out.println("2. Customer");
    int option = sc.nextInt();
    switch (option) {
      case 1:
        System.out.println("Login");
        int option1 = sc.nextInt();
        if (option1 == 1) {
          Auth.admin();
        } else {
          System.out.println("Invalid Option");
        }
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
      default:
        System.out.println("Invalid Option");
        break;
    }
  }
}