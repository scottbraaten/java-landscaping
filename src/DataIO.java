
import java.sql.*;
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

    private final String DATABASE_NAME = "cis355a";
    private final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private final String USER_NAME = "student";
    private final String PASSWORD = "student";

    // Default constructor
    public DataIO() {

    }

    public void add(Customer cust) {

    }

    public void delete(String deleteName) {

    }

    public ArrayList<Customer> getList() {
        return null;
    }

}
