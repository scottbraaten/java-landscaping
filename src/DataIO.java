
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Scott Braaten
 */

public class DataIO {
    
    // Default constructor
    public DataIO() {
        
    }
    
    public void add(Customer cust) throws IOException {
        // open/create file to which data is appended
        BufferedWriter outfile = new BufferedWriter(new FileWriter("Customers.txt", true));
        
        // write object's data to file with # as separators
        outfile.write(cust.getName());
        outfile.write("#" + cust.getAddress());
        outfile.write("#" + cust.getYardType());
        outfile.write("#" + cust.getLength());
        outfile.write("#" + cust.getWidth());
        outfile.write("#" + cust.getTotalCost());
        outfile.newLine();
        
        // close file
        outfile.close();
    }
    
    public void delete(int customerID) {
        
    }
    
    public ArrayList<Customer> getList() {
        
        return null;
        
    }

}
