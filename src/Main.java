import java.util.Objects;
import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);
  static  {
    System.out.println("=====|| Welcome to our Electric Car Rental System ||=====");
    System.out.println("=====|| PLease Feel Comfortable using our System  ||======");
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
            Authentication obj = new Authentication();
            obj.admin();
            obj.authenticationAdmin();
            break;
          case 2:

        }
    }
  }
}

// Authentication System
class Authentication {
  Scanner sc = new Scanner(System.in);
  protected String adminUserName, customersUserName;
  protected String adminPassword, customersPasswords;

  protected void admin() {
    System.out.print("Username: ");
    adminUserName = sc.next("abcdefghijklmnopqrstuvwxyz1234567890");
    System.out.println("Password: ");
    adminPassword = sc.next("abcdefghijklmnopqrstuvwxyz!@#%&*-+/.,;':?><ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
  }

  void authenticationAdmin() {
    try {
      if (Objects.equals(adminUserName, "abhirup")) {
        if (adminPassword == "12345") {
          System.out.println("Login Successful........");
        } else {
          System.out.println("Password Don't Matched............");
          System.out.println("Exiting Software Due to some Authentication Issue............");
          System.exit(0);
        }
      } else {
        System.out.println("Username don't matched............");
        System.out.println("Exiting Software Due to some Authentication Issue............");
        System.exit(0);
      }
    } catch (Exception e) {
      System.out.println("Something Went wrong..........");
    }
  }
  protected void customer() {
    System.out.print("Username: ");
    customersUserName = sc.next("abcdefghijklmnopqrstuvwxyz1234567890");
    System.out.println("Password: ");
    customersPasswords = sc.next("abcdefghijklmnopqrstuvwxyz!@#%&*-+/.,;':?><ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
  }
}
class Signup {

}