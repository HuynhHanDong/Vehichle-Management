/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Huynh Han Dong
 */
public class Vehicle implements Serializable{
    private String id;
    private String name;
    private String color;
    private int price;
    private String brand;
    private String type;
    private int productYear;
    
    public Vehicle(){
    }
    
    public Vehicle(String id, String name, String color, int price, String brand, String type, int productYear){
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
        this.type = type;
        this.productYear = productYear;
    }
    
    public String getID(){
        return id;
    }
    
    public void setID(String id){
        this.id = id;
    }
    
    public String getName(){
        return id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getColor(){
        return id;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public int getPrice(){
        return price;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public void setBrand(String brand){
        this.brand = brand;
    }
    
    public String getType(){
        return type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public int getProductYear(){
        return productYear;
    }

    public void setProductYear(int productYear){
        this.productYear = productYear;
    }
    
    @Override
    public String toString(){
        return "ID:" + id + " Name:" + name + " Color:" + color + " Price:" + price + " Brand:" + brand + " Type:" + type + " Product year:" + productYear;
    }
}