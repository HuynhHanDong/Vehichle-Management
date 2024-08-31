/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workwithfile;

import controllers.VehicleList;
import java.util.Scanner;
import models.IVehicleList;

/**
 *
 * @author Huynh Han Dong
 */
public class WorkWithFile {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        IVehicleList list = new VehicleList();
        boolean menu = true;

        while (menu) {
            System.out.println("\n----------- Menu -----------");
            System.out.println("0. Add new vehicle");
            System.out.println("1. Check existing vehicle");
            System.out.println("2. Update vehicle");
            System.out.println("3. Delete vehicle");
            System.out.println("4. Search vehicle");
            System.out.println("5. Display vehicle");
            System.out.println("6. Save data to file");
            System.out.println("7. Exist");
            System.out.println("----------------------------");

            try {
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter your choice: ");
                int choice = scan.nextInt();
                switch (choice){
                    case 0:
                        list.add();
                        break;
                    case 1:
                        list.check();
                        break;
                    case 2:
                        list.update();
                        break;
                    case 3:
                        list.delete();
                        break;
                    case 4:
                        System.out.println("\n----------- Menu -----------");
                        System.out.println("1. Search by id");
                        System.out.println("2. Search by name");
                        System.out.println("----------------------------");
                        System.out.print("Enter your choice: ");
                        int num4 = scan.nextInt();
                        switch (num4){
                            case 1:
                                list.searchId();
                                break;
                            case 2:
                                list.searchName();
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                    case 5:
                        System.out.println("\n----------- Menu -----------");
                        System.out.println("1. Display all");
                        System.out.println("2. Display all by descending price");
                        System.out.println("----------------------------");
                        System.out.print("Enter your choice: ");
                        int num5 = scan.nextInt();
                        switch (num5){
                            case 1:
                                list.displayAll();
                                break;
                            case 2:
                                list.displayDecsendingPrice();
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                    case 6:
                        list.saveToFile();
                        break;
                    case 7:
                        System.out.println("Exit.");
                        menu = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } 
            catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}
