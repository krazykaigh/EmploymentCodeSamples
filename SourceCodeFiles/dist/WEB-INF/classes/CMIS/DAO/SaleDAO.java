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
import CMIS.Model.CustomerIDs;
import CMIS.Model.HomeIDs;
import CMIS.Model.SaleReport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import CMIS.Model.Sale;
import CMIS.Util.DbUtil;
import java.io.IOException;

public class SaleDAO 
{
    private List<AgentIDs> agentList;
    private List<CustomerIDs> customerList;
    private List<HomeIDs> homeList;
    private Sale sale;
    private SaleReport saleRpt;
    
    private Connection connection;
    public SaleDAO() throws IOException
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

    public void addSale(Sale sale) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the SaleDAO.addSale action");
        
        try 
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into sale_t(saleID,actualamt,saledate,custID,agentID,homeID,contractID) " +
                    "values (SaleID_number_seq.NEXTVAL,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setDouble(1, sale.getActualamt());
            preparedStatement.setDate(2, new java.sql.Date(sale.getSaledate().getTime()));
            preparedStatement.setInt(3, sale.getCustID());
            preparedStatement.setInt(4, sale.getAgentID());
            preparedStatement.setInt(5, sale.getHomeID());
            preparedStatement.setString(6, sale.getContractID());
            preparedStatement.executeUpdate();
            
            connection.commit();
            connection.setAutoCommit(true);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    public void deleteSale(int saleId) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the SaleDAO.deleteSale action");
        
        try 
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from sale_t where saleID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, saleId);

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
    
    public void updateSale(Sale sale) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the SaleDAO.updateSale action");

        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("update sale_t set " +
                " actualamt=?, saledate=?, custID=?, agentID=?, homeID=?, contractID=? " +
				"where saleID=?");
            // Debug - Verify statement
            System.out.println("Mid preparedStatement");    
            
            // Parameters start with 1
            preparedStatement.setDouble(1, sale.getActualamt());
            preparedStatement.setDate(2, new java.sql.Date(sale.getSaledate().getTime()));
            preparedStatement.setInt(3, sale.getCustID());
            preparedStatement.setInt(4, sale.getAgentID());
            preparedStatement.setInt(5, sale.getHomeID());
            preparedStatement.setString(6, sale.getContractID());
            preparedStatement.setInt(7, sale.getSaleID());

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

    public List<CustomerIDs> getCustomerList()
    {
        // DEBUG - Location of activity
        System.out.println("Inside the SaleDAO.getCustomerList action");

        customerList = new ArrayList<CustomerIDs>();
        int intCust;
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select custID from customer_t order by custID");
            while (rs.next()) 
            {
                intCust = rs.getInt("custID");
                CustomerIDs cs     = new CustomerIDs(intCust); 
                customerList.add(cs);        
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return customerList;
    }
    
    
    public List<AgentIDs> getAgentList()
    {
        // DEBUG - Location of activity
        System.out.println("Inside the SaleDAO.getAgentList action");

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

    public List<HomeIDs> getHomeList()
    {
        // DEBUG - Location of activity
        System.out.println("Inside the SaleDAO.getHomeList action");

        homeList = new ArrayList<HomeIDs>();
        int intHome;
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select homeID from home_t order by homeID");
            while (rs.next()) 
            {
                intHome = rs.getInt("homeID");
                HomeIDs hms     = new HomeIDs(intHome); 
                homeList.add(hms);        
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return homeList;
    }

    public List<Sale> getAllSales()
    {
        // DEBUG - Location of activity
        System.out.println("Inside the SaleDAO.getAllSales action");

        List<Sale> sales = new ArrayList<Sale>();
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from sale_t order by saleID");
            while (rs.next()) 
            {
                Sale sale = new Sale();
                sale.setSaleID(rs.getInt("saleID"));
                sale.setActualamt(Double.parseDouble(rs.getString("actualamt")));
                sale.setSaledate(rs.getDate("saledate"));
                sale.setCustID(rs.getInt("custID"));
                sale.setAgentID(rs.getInt("agentID"));
                sale.setHomeID(rs.getInt("homeID"));
                sale.setContractID(rs.getString("contractID"));
                sales.add(sale);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return sales;
    }
    
    public Sale getSaleById(int saleId) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the SaleDAO.getSaleById action");

        sale = new Sale();
        try 
        {
            PreparedStatement preparedStatement = connection.
                prepareStatement("select * from sale_t where saleID=?");
            preparedStatement.setInt(1, saleId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                sale.setSaleID(rs.getInt("saleID"));
                sale.setActualamt(Double.parseDouble(rs.getString("actualamt")));
                sale.setSaledate(rs.getDate("saledate"));
                sale.setCustID(rs.getInt("custID"));
                sale.setAgentID(rs.getInt("agentID"));
                sale.setHomeID(rs.getInt("homeID"));
                sale.setContractID(rs.getString("contractID"));

            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
        return sale;
    }
    
    public SaleReport getSalesInfo()
    {
        // DEBUG - Location of activity
        System.out.println("Inside the SaleDAO.getSaleInfo action");

        saleRpt = new SaleReport();
        int totSale = 0;
        double sumSale = 0;
        double avgSale = 0;
        Statement stmnt = null;
        ResultSet rs = null;
        
        try 
        {
            stmnt = connection.createStatement();
            rs = stmnt.executeQuery("select SUM(actualamt) AS sumSales from sale_t");
            while(rs.next())
            {
                sumSale += rs.getDouble("sumSales");
            }
            saleRpt.setSalesSum(sumSale);
            // DEBUG - Location of activity
            System.out.println("*** OUT: Sum of sales = " + saleRpt.getSalesSum());
            
            rs = stmnt.executeQuery("select AVG(actualamt) AS avgSales from sale_t");
            while (rs.next())
            {
                avgSale += rs.getDouble("avgSales");
            }
            saleRpt.setSalesAvg(avgSale);
            // DEBUG - Location of activity
            System.out.println("*** OUT: AVG of sales = " + saleRpt.getSalesAvg());
            
            rs = stmnt.executeQuery("select COUNT(*) AS salesCNT from sale_t");
             while (rs.next())
            {
                totSale += rs.getDouble("salesCNT");
            }
           saleRpt.setTotalSales(totSale);
            // DEBUG - Location of activity
            System.out.println("*** OUT: COUNT of salse = " + saleRpt.getTotalSales());
            
            
        }
         catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
        return saleRpt;
       
    }
}
