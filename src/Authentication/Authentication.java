package Authentication;

import java.util.Objects;
import java.util.Scanner;
import java.sql.*;

// Authentication System
public class Authentication {
  public Authentication() throws ClassNotFoundException, SQLException {
    String url = "jdbc:mysql://localhost:3306/project";
    String uname = "root";
    String pass = "AbhirupKeya";
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(url, uname, pass);
  }
  Scanner sc = new Scanner(System.in);
  protected String adminUserName, customersUserName;
  protected String adminPassword, customersPassword;

  public void admin() {
    System.out.print("Admin Username: ");
    adminUserName = sc.nextLine();
    System.out.print("Admin Password: ");
    adminPassword = sc.nextLine();
  }

  public void authenticationAdmin() {
    try {
      if (Objects.equals(adminUserName, "abhirup")) {
        if (Objects.equals(adminPassword, "12345")) {
          System.out.println("Login Successful.................");
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

  public void customer() {
    System.out.print("Customer Username: ");
    customersUserName = sc.nextLine();
    System.out.print("Customer Password: ");
    customersPassword = sc.nextLine();
  }

  public void authenticationCustomer() {
    try {
      if (Objects.equals(customersUserName, "dipty")) {
        if (Objects.equals(customersPassword, "12345")) {
          System.out.println("Login Successful.................");
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
}