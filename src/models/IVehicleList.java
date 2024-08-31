/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.VehicleList;

/**
 *
 * @author Huynh Han Dong
 */
public interface IVehicleList {

    void add();

    void check();

    void update();

    void delete();

    void searchId();

    void searchName();

    void displayAll();

    void displayDecsendingPrice();

    void saveToFile();

    VehicleList readFile();
}
