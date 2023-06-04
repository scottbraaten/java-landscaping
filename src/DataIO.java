
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

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

    public void delete(String deleteName) throws IOException {
        ArrayList<Customer> customers = getList();
        
        // delete old file
        File oldFile = new File("Customers.txt");
        if (oldFile.exists() == false) {
            throw new IOException("File does not exist!");
        }
        oldFile.delete();
        
        // write good records to file
        for (Customer cust : customers) {
            if (deleteName.equalsIgnoreCase(cust.getName()) == false) {
                add(cust);
            }
        }
    }

    public ArrayList<Customer> getList() throws IOException {
        // get Customer objects from file and return as ArrayList

        // create ArrayList
        ArrayList<Customer> customers = new ArrayList<Customer>();

        // create counter to assign unique ids to Customer objects
        int id = 0;

        // read data from file
        BufferedReader inbuffer = new BufferedReader(new FileReader("Customers.txt"));
        StringTokenizer tokens;

        // get first line
        String inputString = inbuffer.readLine();
        while (inputString != null) {
            // break line into pieces with Tokenizer
            tokens = new StringTokenizer(inputString, "#");

            String name = tokens.nextToken();
            String address = tokens.nextToken();
            String yardType = tokens.nextToken();
            double length = Double.parseDouble(tokens.nextToken());
            double width = Double.parseDouble(tokens.nextToken());
            double totalCost = Double.parseDouble(tokens.nextToken());

            // create Customer onject with info and add to customers
            Customer cust = new Customer(id++, name, address, yardType, length, width, totalCost);
            customers.add(cust);
            
            // read next line
            inputString = inbuffer.readLine();
        }
        
        // close pipe to file
        inbuffer.close();
        
        // return customers
        return customers;

    }

}
