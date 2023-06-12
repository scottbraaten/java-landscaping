
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

    public void add(Customer cust) throws ClassNotFoundException, SQLException {
        // check for driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // connect to db
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);

        // add record
        String strSQL = "INSERT INTO landscape (CustomerName, CustomerAddress, "
                + "LandscapeType, YardLength, YardWidth, LandscapeCost)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        pstmt.setString(1, cust.getName());
        pstmt.setString(2, cust.getAddress());
        pstmt.setString(3, cust.getYardType());
        pstmt.setDouble(4, cust.getLength());
        pstmt.setDouble(5, cust.getWidth());
        pstmt.setDouble(6, cust.getTotalCost());

        // execute preparedstatement
        pstmt.execute();

        // close connection
        conn.close();
    }

    public void delete(int customerID) throws SQLException {
        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING,
                USER_NAME, PASSWORD);

        // delete the record
        String SQL = "DELETE FROM landScape WHERE CustomerID = ?";
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setInt(1, customerID);
        pstmt.execute();

        // close the database connection
        conn.close();

    }

    public ArrayList<Customer> getList() throws SQLException {
        // create AL
        ArrayList<Customer> list = new ArrayList<Customer>();

        // connect to db
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);

        Statement statement = conn.createStatement();
        String SQL = "Select * from landscape";
        ResultSet rs = statement.executeQuery(SQL);

        while (rs.next()) {
            // create Customer
            Customer client = new Customer();
            client.setCustomerID(rs.getInt(1));
            client.setName(rs.getString(2));
            client.setAddress(rs.getString(3));
            client.setYardType(rs.getString(4));
            client.setLength(rs.getDouble(5));
            client.setWidth(rs.getDouble(6));
            client.setTotalCost(rs.getDouble(7));

            // add client to list
            list.add(client);

        }
        // close conn
        conn.close();

        return list;
    }

}
