package AdminMenue;

import java.util.Scanner;

public class AdminController {
  Scanner sc = new Scanner(System.in);
  public void displayMenu() {
    System.out.println("Admin Menu:");
    System.out.println("1. Add Vehicle");
    System.out.println("2. Update Vehicle");
    System.out.println("3. Delete Vehicle");
    System.out.println("7. View Rentals");
    System.out.println("0. Exit");
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
          addUser();
          break;
        case 5:
          updateUser();
          break;
        case 6:
          deleteUser();
          break;
        case 7:
          viewRentals();
          break;
        case 8:
          generateReport();
          break;
        case 0:
          exit = true;
          System.out.println("Exiting Admin Menu.");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

    private void addVehicle() {
        // Implement logic to add a new vehicle
        System.out.println("Adding a new vehicle...");
    }

    private void updateVehicle() {
        // Implement logic to update a vehicle
        System.out.println("Updating a vehicle...");
    }

    private void deleteVehicle() {
        // Implement logic to delete a vehicle
        System.out.println("Deleting a vehicle...");
    }

    private void addUser(){
        // Implement logic to add a User
        System.out.println("Adding a new User...");
    }

    private void updateUser(){
        //Implement logic to update user....
        System.out.println("Updating User info...");
    }

    private void deleteUser(){
        //Implement logic to delete user....
        System.out.println("Deleting User...");
    }



    private void viewRentals() {
        // Implement logic to view rentals
        System.out.println("Viewing rentals...");
    }

    private void generateReport() {
        // Implement logic to generate a report
        System.out.println("Generating report...");
    }
}
