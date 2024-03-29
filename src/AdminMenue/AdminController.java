package AdminMenue;

import java.util.Scanner;

public class AdminController {
  Scanner sc = new Scanner(System.in);
  public void displayMenu() {
    System.out.println("Admin Menu:");
    System.out.println("1. Add Vehicle");
    System.out.println("2. Update Vehicle");
    System.out.println("3. Delete Vehicle");
    System.out.println("4. View Rentals");
    System.out.println("5. Exit");
    System.out.print("Enter your choice: ");
  }

  public void MainMenu() {
    boolean exit = false;
    while (!exit) {
      displayMenu();
      int choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1:
          addVehicle();
          break;
        case 2:
          updateVehicle();
          break;
        case 3:
          deleteVehicle();
          break;
        case 4:
          viewRentals();
          break;
        case 5:
          exit = true;
          System.out.println("Exiting...............");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  protected void addVehicle() {
    System.out.println("Add a New Vehicle in the inventory..............");

  }

  protected void updateVehicle() {
    System.out.println("Updating the vehicle which is present in the inventory..............");
  }

  protected void deleteVehicle() {
    System.out.println("Select the car from the inventory to remove the records.....................");
  }

  protected void viewRentals() {
    System.out.println("View All the cars that are being rented.........................");
  }
}
