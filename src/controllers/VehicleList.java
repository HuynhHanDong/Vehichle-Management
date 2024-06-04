/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import models.InterfaceVehicleList;
import models.Vehicle;

/**
 *
 * @author Huynh Han Dong
 */
public class VehicleList extends ArrayList<Vehicle> implements InterfaceVehicleList{

    @Override
    public void add() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter id: ");
        String id = scan.nextLine();
            
        VehicleList list = this.readFile();
        for (Vehicle veh : list){
            if (veh.getID().equals(id)){
                System.out.println("This vehicle already existed.");
                return;
            }
        }
        System.out.print("Enter name: ");
        String name = scan.nextLine();
        System.out.print("Enter color: ");
        String color = scan.nextLine();
        System.out.print("Enter brand: ");
        String brand = scan.nextLine();
        System.out.print("Enter type: ");
        String type = scan.nextLine();
        System.out.print("Enter year of production: ");
        int productYear = scan.nextInt();
        System.out.print("Enter price: ");
        double price = scan.nextInt();
        
        Vehicle vehicle = new Vehicle(id, name, color, price, brand, type, productYear);
        this.add(vehicle);
        System.out.println("Added Successfully");
        this.saveToFile();
    }

    @Override
    public void check() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter id to check: ");
        String id = scan.nextLine();
        VehicleList list = this.readFile();
        for (Vehicle veh : list){
            if (veh.getID().equals(id)){
                System.out.println("Exist vehicle.");
                return;
            }
        }
        System.out.println("No vehicle found!");
    }

    @Override
    public void update() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter id to update: ");
        String id = scan.nextLine();
        VehicleList list = this.readFile();
        for (Vehicle veh : list){
            if (veh.getID().equals(id)){
                System.out.print("Enter new name: ");
                String name = scan.nextLine();
                System.out.print("Enter new color: ");
                String color = scan.nextLine();
                System.out.print("Enter new brand: ");
                String brand = scan.nextLine();
                System.out.print("Enter new type: ");
                String type = scan.nextLine();
                System.out.print("Enter new year of production: ");
                int productYear = scan.nextInt();
                System.out.print("Enter new price: ");
                double price = scan.nextInt();
                Vehicle vehicle = new Vehicle(id, name, color, price, brand, type, productYear);
                
                this.set(list.indexOf(veh), vehicle);
                System.out.println("Updated: " + veh.toString());
                this.saveToFile();
                return;
            }
        }
        System.out.println("Vehicle does not exist.");
    }

    @Override
    public void delete() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter id to delete: ");
        String id = scan.nextLine();
        VehicleList list = this.readFile();
        for (Vehicle veh : list){
            if (veh.getID().equals(id)){
                System.out.println("Are you sure you want to delete this vehicle?  yes/no");
                String ans = scan.nextLine();
                if ("yes".equals(ans)){
                    this.remove(list.indexOf(veh));
                    System.out.println("Deleted");
                    this.saveToFile();
                    return;
                }
            }
        }
        System.out.println("Vehicle does not exist.");
    }

    @Override
    public void searchId() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter id to search: ");
        String id = scan.nextLine();
        VehicleList list = this.readFile();
        for (Vehicle veh : list){
            if (veh.getID().equals(id)){
                System.out.println(veh.toString());
                return;
            }
        }
        System.out.println("No vehicle found!");
    }

    @Override
    public void searchName() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter name to search: ");
        String name = scan.nextLine();
        VehicleList list = this.readFile();
        list.sort(Comparator.comparing(Vehicle::getID).reversed());
        boolean found = false;
        for (Vehicle veh : list){
            if (veh.getName().equals(name)){
                System.out.println(veh.toString());
                found = true;
            }
        }
        if (found == false) {
            System.out.println("No vehicle found!");
        }
    }

    @Override
    public void displayAll() {
        VehicleList list = this.readFile();
        for (Vehicle veh : list){
            System.out.println(veh.toString());
        }
    }

    @Override
    public void displayDecsendingPrice() {
        VehicleList list = this.readFile();
        list.sort(Comparator.comparingDouble(Vehicle::getPrice).reversed());
        System.out.println("All Vehicles sorted by price descending:");
        for (Vehicle veh : list){
            System.out.println(veh.toString());
        }
    }

    @Override
    public void saveToFile() {
        try(FileOutputStream fileOutput = new FileOutputStream("src\\data\\Vehicle.dat");
            ObjectOutputStream write = new ObjectOutputStream(fileOutput)){
            
            write.writeObject(this);
            write.close();
            System.out.println("Saved");
        }
        catch(IOException e){
            System.out.println("Failed to save");
        }
    }

    @Override
    public void printAll() {
        VehicleList list = this.readFile();
        try {
            FileWriter fileWriter = new FileWriter("src\\data\\VehicleList.txt");
            
            for (Vehicle veh : list){
                String text = veh.toString();
                fileWriter.write(text + "\n");
            }
            fileWriter.close();
            System.out.println("Printed to file");
        } 
        catch(IOException e){
            System.out.println("Failed to print");
        }
    }
    
    @Override
    public void printDecsendingPrice() {
        VehicleList list = this.readFile();
        try {
            FileWriter fileWriter = new FileWriter("src\\data\\VehicleList.txt");
            list.sort(Comparator.comparingDouble(Vehicle::getPrice).reversed());

            for (Vehicle veh : list){
                String text = veh.toString();
                fileWriter.write(text + "\n");
            }
            fileWriter.close();
            System.out.println("Printed to file");
        } 
        catch(IOException e){
            System.out.println("Failed to print");
        }
    }

    @Override
    public VehicleList readFile() {
        VehicleList result = new VehicleList();
        try(FileInputStream fileInput = new FileInputStream("src\\data\\Vehicle.dat");
            ObjectInputStream read = new ObjectInputStream(fileInput)){
            
            result = (VehicleList) read.readObject();
            read.close();
        } catch(EOFException eof){
            System.out.println("Failed to read");
        } catch(IOException | ClassNotFoundException ex){
            System.out.println("Failed to read");
        } 
        return result;
    }
}
    