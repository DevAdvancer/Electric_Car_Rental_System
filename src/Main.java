import java.util.Objects;
import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);

  static {
    System.out.println("=====|| Welcome to our Electric Car Rental System ||=====");
    System.out.println("=====|| Please Feel Comfortable using our System  ||======");
  }

  public static void main(String[] args) {
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
            Authentication adminAuth = new Authentication();
            adminAuth.admin();
            adminAuth.authenticationAdmin();
            break;
          case 2:
            // Implement customer login
            break;
          default:
            System.out.println("Invalid Option");
            break;
        }
        break;
      case 2:
        // Implement signup functionality
        break;
      default:
        System.out.println("Invalid Option");
        break;
    }
  }
}

// Authentication System
class Authentication {
  Scanner sc = new Scanner(System.in);
  protected String adminUserName, customersUserName;
  protected String adminPassword, customersPassword;

  protected void admin() {
    System.out.print("Admin Username: ");
    adminUserName = sc.nextLine();
    System.out.print("Admin Password: ");
    adminPassword = sc.nextLine();
  }

  void authenticationAdmin() {
    try {
      if (Objects.equals(adminUserName, "abhirup")) {
        if (Objects.equals(adminPassword, "12345")) {
          System.out.println("Login Successful.");
        } else {
          System.out.println("Password Doesn't Match.");
          System.out.println("Exiting Software Due to Authentication Issue.");
          System.exit(0);
        }
      } else {
        System.out.println("Username Doesn't Match.");
        System.out.println("Exiting Software Due to Authentication Issue.");
        System.exit(0);
      }
    } catch (Exception e) {
      System.out.println("Something Went Wrong.");
    }
  }

  protected void customer() {
    System.out.print("Customer Username: ");
    customersUserName = sc.nextLine();
    System.out.print("Customer Password: ");
    customersPassword = sc.nextLine();
  }
}
