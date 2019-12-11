/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CMIS.DAO;

/**
 *
 * @author Kaigh
 */
import CMIS.Model.AgentIDs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import CMIS.Model.Customer;
import CMIS.Util.DbUtil;
import java.io.IOException;

public class CustomerDAO 
{
    private List<AgentIDs> agentList;
    private Customer customer;
    
    private Connection connection;
    public CustomerDAO() throws IOException
    {
        try
        {
           connection = DbUtil.getConnection();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
     }

    public void addCustomer(Customer customer) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the CustomerDAO.addCustomer action");
        
        try 
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into customer_t(custID,first,mi,last,street,city,state,"+
					"zipcode,home_phone,DOB,profession,referrer,agentID) "+
                    "values (CustID_number_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, customer.getFirst());
            preparedStatement.setString(2, customer.getMi());
            preparedStatement.setString(3, customer.getLast());
            preparedStatement.setString(4, customer.getStreet());
            preparedStatement.setString(5, customer.getCity());
            preparedStatement.setString(6, customer.getState());
            preparedStatement.setString(7, customer.getZipcode());
            preparedStatement.setString(8, customer.getHome_phone());
            preparedStatement.setDate(9, new java.sql.Date(customer.getDob().getTime()));
            preparedStatement.setString(10, customer.getProfession());
            preparedStatement.setString(11, customer.getReferrer());
            preparedStatement.setInt(12, customer.getAgentID());
            preparedStatement.executeUpdate();
            
            connection.commit();
            connection.setAutoCommit(true);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    public void deleteCustomer(int custId) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the CustomerDAO.deleteCustomer action");
        
        try 
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from customer_t where custID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, custId);

            // Debug - Verify statement
            System.out.println(preparedStatement);
            
            preparedStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            
            // Debug - Verify statement
            System.out.println("Delete action just occured.");

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    public void updateCustomer(Customer customer) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the CustomerDAO.updateCustomer action");

        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("update customer_t set " +
                " first=?, mi=?, last=?, street=?, city=?, state=?, zipcode=?,  home_phone=?, DOB=?, " +
				"profession=?, referrer=?, agentID =? where custID=?");
            // Debug - Verify statement
            System.out.println("Mid preparedStatement");    
            
            // Parameters start with 1
            preparedStatement.setString(1, customer.getFirst());
            preparedStatement.setString(2, customer.getMi());
            preparedStatement.setString(3, customer.getLast());
            preparedStatement.setString(4, customer.getStreet());
            preparedStatement.setString(5, customer.getCity());
            preparedStatement.setString(6, customer.getState());
            preparedStatement.setString(7, customer.getZipcode());
            preparedStatement.setString(8, customer.getHome_phone());
            preparedStatement.setDate(9, new java.sql.Date(customer.getDob().getTime()));
            preparedStatement.setString(10, customer.getProfession());
            preparedStatement.setString(11, customer.getReferrer());
            preparedStatement.setInt(12, customer.getAgentID());
            preparedStatement.setInt(13, customer.getCustID());

            // Debug - Verify statement
            System.out.println("ALERT: After UPDATE preparedStatement");

            preparedStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            
            // Debug - Verify statement
            System.out.println("Update action just occured.");

        } 
	catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    public List<AgentIDs> getAgentList()
    {
        // DEBUG - Location of activity
        System.out.println("Inside the CustomerDAO.getAgentList action");

        agentList = new ArrayList<AgentIDs>();
        int intAgent;
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select agentID from agent_t order by agentID");
            while (rs.next()) 
            {
                intAgent = rs.getInt("agentID");
                AgentIDs ags     = new AgentIDs(intAgent); 
                agentList.add(ags);        
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return agentList;
    }

    public List<Customer> getAllCustomers()
    {
        // DEBUG - Location of activity
        System.out.println("Inside the CustomerDAO.getAllCustomers action");

        List<Customer> customers = new ArrayList<Customer>();
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from customer_t order by custID");
            while (rs.next()) 
            {
                Customer customer = new Customer();
                customer.setCustID(rs.getInt("custID"));
                customer.setFirst(rs.getString("first"));
                customer.setMi(rs.getString("mi"));
                customer.setLast(rs.getString("last"));
                customer.setStreet(rs.getString("street"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setZipcode(rs.getString("zipcode"));
                customer.setHome_phone(rs.getString("home_phone"));
                customer.setDob(rs.getDate("dob"));
                customer.setProfession(rs.getString("profession"));
                customer.setReferrer(rs.getString("referrer"));
                customer.setAgentID(rs.getInt("agentID"));
                customers.add(customer);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return customers;
    }
    
    public Customer getCustomerById(int custId) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the CustomerDAO.getCustomerById action");

        customer = new Customer();
        try 
        {
            PreparedStatement preparedStatement = connection.
                prepareStatement("select * from customer_t where custID=?");
            preparedStatement.setInt(1, custId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                customer.setCustID(rs.getInt("custID"));
                customer.setFirst(rs.getString("first"));
                customer.setMi(rs.getString("mi"));
                customer.setLast(rs.getString("last"));
                customer.setStreet(rs.getString("street"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setZipcode(rs.getString("zipcode"));
                customer.setHome_phone(rs.getString("home_phone"));
                customer.setDob(rs.getDate("dob"));
                customer.setProfession(rs.getString("profession"));
                customer.setReferrer(rs.getString("referrer"));
                customer.setAgentID(rs.getInt("agentID"));

            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
        return customer;
    }
}
