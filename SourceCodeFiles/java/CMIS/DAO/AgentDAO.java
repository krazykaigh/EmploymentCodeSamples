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
import CMIS.Model.Agent;
import CMIS.Util.DbUtil;
import java.io.IOException;

public class AgentDAO 
{
    private Connection connection;
    public AgentDAO() throws IOException
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

    public void addAgent(Agent agent) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the AgentDAO.addAgent action");
        
        try 
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into agent_t(agentID,title,first,mi,last,hireDate,home_phone,cell_phone,pager) "+
                    "values (AgentID_number_seq.NEXTVAL,?,?,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, agent.getTitle());
            preparedStatement.setString(2, agent.getFirst());
            preparedStatement.setString(3, agent.getMi());
            preparedStatement.setString(4, agent.getLast());
            preparedStatement.setDate(5, new java.sql.Date(agent.getHireDate().getTime()));
            preparedStatement.setString(6, agent.getHome_phone());
            preparedStatement.setString(7, agent.getCell_phone());
            preparedStatement.setString(8, agent.getPager());
            preparedStatement.executeUpdate();
            
            connection.commit();
            connection.setAutoCommit(true);
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    public void deleteAgent(int agentId) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the AgentDAO.deleteAgent action");
        
        try 
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from agent_t where agentID=?");
            // Parameters start with 1
            preparedStatement.setInt(1, agentId);

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
    
    public void updateAgent(Agent agent) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the AgentDAO.updateAgent action");

        try
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("update agent_t set title=?," +
                " first=?, mi=?, last=?, hireDate=?, home_phone=?, cell_phone=?, pager=? where agentID=?");
            // Debug - Verify statement
            System.out.println("Mid preparedStatement");    
            
            // Parameters start with 1
            preparedStatement.setString(1, agent.getTitle());
            preparedStatement.setString(2, agent.getFirst());
            preparedStatement.setString(3, agent.getMi());
            preparedStatement.setString(4, agent.getLast());
            preparedStatement.setDate(5, new java.sql.Date(agent.getHireDate().getTime()));
            preparedStatement.setString(6, agent.getHome_phone());
            preparedStatement.setString(7, agent.getCell_phone());
            preparedStatement.setString(8, agent.getPager());
            preparedStatement.setInt(9, agent.getAgentID());

            // Debug - Verify statement
            System.out.println("After preparedStatement");

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
    
    public List<Agent> getAllAgents()
    {
        // DEBUG - Location of activity
        System.out.println("Inside the AgentDAO.getAllAgents action");

        List<Agent> agents = new ArrayList<Agent>();
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from agent_t order by agentID");
            while (rs.next()) 
            {
                Agent agent = new Agent();
                agent.setAgentID(rs.getInt("agentID"));
                agent.setTitle(rs.getString("title"));
                agent.setFirst(rs.getString("first"));
                agent.setMi(rs.getString("mi"));
                agent.setLast(rs.getString("last"));
                agent.setHireDate(rs.getDate("hireDate"));
                agent.setHome_phone(rs.getString("home_phone"));
                agent.setCell_phone(rs.getString("cell_phone"));
                agent.setPager(rs.getString("pager"));
                agents.add(agent);
            }
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return agents;
    }
    
    public Agent getAgentById(int agentId) 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the AgentDAO.getAgentById action");

        Agent agent = new Agent();
        try 
        {
            PreparedStatement preparedStatement = connection.
                prepareStatement("select * from agent_t where agentID=?");
            preparedStatement.setInt(1, agentId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                agent.setAgentID(rs.getInt("agentID"));
                agent.setTitle(rs.getString("title"));
                agent.setFirst(rs.getString("first"));
                agent.setMi(rs.getString("mi"));
                agent.setLast(rs.getString("last"));
                agent.setHireDate(rs.getDate("hireDate"));
                agent.setHome_phone(rs.getString("home_phone"));
                agent.setCell_phone(rs.getString("cell_phone"));
                agent.setPager(rs.getString("pager"));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return agent;
    }
}


