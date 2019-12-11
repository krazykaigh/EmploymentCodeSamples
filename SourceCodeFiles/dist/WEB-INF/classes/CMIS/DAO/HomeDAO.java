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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import CMIS.Model.Home;
import CMIS.Util.DbUtil;
import java.io.IOException;

public class HomeDAO 
{
    private Home home;
    
    private Connection connection;
    public HomeDAO() throws IOException
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

    public void addHome(Home home) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the HomeDAO.addHome action");
        
        try 
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into home_t(homeID,lot_size,location,model_ID,purchaseprice," +
                            "street,city,state,zipcode) "+
                    "values (HomeID_number_seq.NEXTVAL,?,?,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, home.getLot_size());
            preparedStatement.setString(2, home.getLocation());
            preparedStatement.setString(3, home.getModel_ID());
            preparedStatement.setDouble(4, home.getPurchaseprice());
            preparedStatement.setString(5, home.getStreet());
            preparedStatement.setString(6, home.getCity());
            preparedStatement.setString(7, home.getState());
            preparedStatement.setString(8, home.getZipcode());
            preparedStatement.executeUpdate();
            
            connection.commit();
            connection.setAutoCommit(true);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    public void deleteHome(int homeId) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the HomeDAO.deleteHome action");
        
        try 
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from home_t where homeID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, homeId);

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
    
    public void updateHome(Home home) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the HomeDAO.updateHome action");

        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("update home_t set " +
                " lot_size=?, location=?, model_ID=?, purchaseprice=?, street=?, city=?, state=?, zipcode=?" +
				" where homeID=?");
            // Debug - Verify statement
            System.out.println("Mid preparedStatement");    
            
            // Parameters start with 1
            preparedStatement.setString(1, home.getLot_size());
            preparedStatement.setString(2, home.getLocation());
            preparedStatement.setString(3, home.getModel_ID());
            preparedStatement.setDouble(4, home.getPurchaseprice());
            preparedStatement.setString(5, home.getStreet());
            preparedStatement.setString(6, home.getCity());
            preparedStatement.setString(7, home.getState());
            preparedStatement.setString(8, home.getZipcode());
            preparedStatement.setInt(9, home.getHomeID());

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
    
    public List<Home> getAllHomes()
    {
        // DEBUG - Location of activity
        System.out.println("Inside the HomeDAO.getAllHomes action");

        List<Home> homes = new ArrayList<Home>();
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from home_t order by homeID");
            while (rs.next()) 
            {
                Home home = new Home();
                home.setHomeID(rs.getInt("homeID"));
                home.setLot_size(rs.getString("lot_size"));
                home.setLocation(rs.getString("location"));
                home.setModel_ID(rs.getString("model_ID"));
                home.setPurchaseprice(Double.parseDouble(rs.getString("purchaseprice")));
                home.setStreet(rs.getString("street"));
                home.setCity(rs.getString("city"));
                home.setState(rs.getString("state"));
                home.setZipcode(rs.getString("zipcode"));
                homes.add(home);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return homes;
    }
    
    public Home getHomeById(int homeId) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the HomeDAO.getHomeById action");

        home = new Home();
        try 
        {
            PreparedStatement preparedStatement = connection.
                prepareStatement("select * from home_t where homeID=?");
            preparedStatement.setInt(1, homeId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                home.setHomeID(rs.getInt("homeID"));
                home.setLot_size(rs.getString("lot_size"));
                home.setLocation(rs.getString("location"));
                home.setModel_ID(rs.getString("model_ID"));
                home.setPurchaseprice(Double.parseDouble(rs.getString("purchaseprice")));
                home.setStreet(rs.getString("street"));
                home.setCity(rs.getString("city"));
                home.setState(rs.getString("state"));
                home.setZipcode(rs.getString("zipcode"));

            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
        return home;
    }
}
