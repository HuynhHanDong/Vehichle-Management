/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workwithfile;

import controllers.VehicleList;
import java.util.Scanner;
import models.InterfaceVehicleList;

/**
 *
 * @author Huynh Han Dong
 */
public class WorkWithFile {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        InterfaceVehicleList list = new VehicleList();
        
        while (true) {
            System.out.println("----- Menu -----");
            System.out.println("0. Add new vehicle");
            System.out.println("1. Check existing vehicle");
            System.out.println("2. Update vehicle");
            System.out.println("3. Delete vehicle");
            System.out.println("4. Search vehicle");
            System.out.println("5. Display vehicle");
            System.out.println("6. Save data to file");
            System.out.println("7. Print vehicle list");
            System.out.println("8. Exist");
        
            try {
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter your choice: ");
                int choice = scan.nextInt();
        
                if (choice == 0) {
                    list.add();
                }
                else if (choice == 1) {
                    list.check();
                } 
                else if (choice == 2) {
                    list.update();
                } 
                else if (choice == 3) {
                    list.delete();
                } 
                else if (choice == 4) {
                    System.out.println("4.1 Search by id");
                    System.out.println("4.2 Search by name");
                    System.out.print("Enter your choice: ");
                    double num4 = scan.nextDouble();
                    if (num4 == 4.1) {
                        list.searchId();
                    }
                    else if (num4 == 4.2) {
                        list.searchName();
                    } 
                    else {
                        System.out.println("Invalid choice. Try again.");
                    }
                } 
                else if (choice == 5) {
                    System.out.println("5.1 Display all");
                    System.out.println("5.2 Display all descending by price");
                    System.out.print("Enter your choice: ");
                    double num5 = scan.nextDouble();
                    if (num5 == 5.1) {
                        list.displayAll();
                    }
                    else if (num5 == 5.2) {
                        list.displayDecsendingPrice();
                    }
                    else {
                        System.out.println("Invalid choice. Try again.");
                    }
                } 
                else if (choice == 6) {
                    list.saveToFile();
                } 
                else if (choice == 7) {
                    System.out.println("7.1 Print all");
                    System.out.println("7.2 Print all descending by price");
                    System.out.print("Enter your choice: ");
                    double num7 = scan.nextDouble();
                    if (num7 == 7.1) {
                        list.printAll();
                    } 
                    else if (num7 == 7.2) {
                        list.printDecsendingPrice();
                    }
                    else {
                        System.out.println("Invalid choice. Try again.");
                    }
                }
                else if (choice == 8) {
                    System.out.println("Exit.");
                    break;
                }
                else {
                    System.out.println("Invalid choice. Try again.");
                }
            }
            catch (Exception e){
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}
