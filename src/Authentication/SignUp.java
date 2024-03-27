package Authentication;

//import java.util.Objects;
import java.util.Scanner;

public class SignUp {
  Scanner sc = new Scanner(System.in);
  protected String UserName;
  protected String Password;

  public void signUp() {
    System.out.print("Username (username will be of in small letters and without any space in between): ");
    UserName = sc.nextLine();
    System.out.print("Password: ");
    Password = sc.nextLine();
  }

  public void addToSql() {
    System.out.println("Successfully Signed Up.........");
  }
}
