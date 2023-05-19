/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.text.DecimalFormat;

/**
 *
 * @author Scott Braaten
 */

public class Customer {
    // Properties
    private int customerID;
    private String name, address, yardType;
    private double length, width, totalCost;

    // Constructors
    public Customer() {
    }

    public Customer(int customerID, String name, String address, String yardType, double length, double width, double totalCost) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.yardType = yardType;
        this.length = length;
        this.width = width;
        this.totalCost = totalCost;
    }

    // Getters and setters
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYardType() {
        return yardType;
    }

    public void setYardType(String yardType) {
        this.yardType = yardType;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    // Custom inherited toString
    @Override
    public String toString() {
        return name;
    }

    // Method returning all details formatted for textArea
    public String getDetails() {
        DecimalFormat fmt = new DecimalFormat("$#,##0.00");
        String output = name + "\n";
        output += address + "\n";
        output += "Type: " + yardType + "\n";
        output += "Width: " + width + "\n";
        output += "Length: " + length + "\n";
        output += "Total Cost: " + fmt.format(totalCost); //currency

        return output;
    }
}
