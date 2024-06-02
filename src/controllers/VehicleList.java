/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter id: ");
            String id = scan.nextLine();
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
            int price = scan.nextInt();
        
            Vehicle vehicle = new Vehicle(id, name, color, price, brand, type, productYear);
            this.add(vehicle);
            System.out.println("Added Successfully");
            this.saveToFile();
        }
        catch (Exception e){
            System.out.println("Failed to add");
        }
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
                System.out.print("Enter name: ");
                String name = scan.nextLine();
                veh.setName(name);
                System.out.print("Enter color: ");
                String color = scan.nextLine();
                veh.setColor(color);
                System.out.print("Enter brand: ");
                String brand = scan.nextLine();
                veh.setBrand(brand);
                System.out.print("Enter type: ");
                String type = scan.nextLine();
                veh.setType(type);
                System.out.print("Enter year of production: ");
                int productYear = scan.nextInt();
                veh.setProductYear(productYear);
                System.out.print("Enter price: ");
                int price = scan.nextInt();
                veh.setPrice(price);
                
                System.out.println("Updated" + veh.toString());
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
                System.out.println("Delete this vehicle?  yes\no");
                String ans = scan.nextLine();
                if (ans == "yes"){
                list.remove(list.indexOf(veh.getID()));
                System.out.println("Deleted");
                this.saveToFile();
                }
            return;
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
        System.out.print("Enter id to search: ");
        String name = scan.nextLine();
        VehicleList list = this.readFile();
        list.sort(null);
        for (Vehicle veh : list){
            if (veh.getName().equals(name)){
                System.out.println(veh.toString());
            }
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveToFile() {
        try(FileOutputStream fileOutput = new FileOutputStream("src\\data\\Vehicle.txt");
            ObjectOutputStream write = new ObjectOutputStream(fileOutput)){
            
            write.writeObject(this);
            System.out.println("Saved");
        }
        catch(IOException e){
            System.out.println("Failed to save");
        }
    }

    @Override
    public void printAll() {
        VehicleList list = this.readFile();
        for (Vehicle veh : list){
            System.out.println(veh.toString());
        }
    }
    
    @Override
    public void printDecsendingPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VehicleList readFile() {
        VehicleList result = new VehicleList();
        try(FileInputStream fileInput = new FileInputStream("src\\data\\Vehicle.txt");
            ObjectInputStream read = new ObjectInputStream(fileInput)){
            
            result = (VehicleList) read.readObject();
        } catch(EOFException eof){
            System.out.println("Failed to read");
        } catch(IOException | ClassNotFoundException ex){
            System.out.println("Failed to read");
        } 
        return result;
    }
}
    