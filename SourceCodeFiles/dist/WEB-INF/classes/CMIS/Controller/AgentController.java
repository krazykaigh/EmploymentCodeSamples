/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package CMIS.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CMIS.DAO.AgentDAO;
import CMIS.Model.Agent;


public class AgentController extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/agent.jsp";
    private static String LIST_AGENT = "/listAgent.jsp";
    private AgentDAO dao;

    public AgentController() 
    {
        super();
        try {
            dao = new AgentDAO();
        } catch (IOException ex) 
        {
            System.out.println("An error occurred instancing dao: " + ex);
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {
        String forward="";
        String action = request.getParameter("action");
        
        // DEBUG - What is the value of var action
        System.out.println("Type of action chosen: " +action);

        if (action.equalsIgnoreCase("delete"))
        {
            // DEBUG - Location of activity
            System.out.println("Inside the DELETE action");
            
            int agentId = Integer.parseInt(request.getParameter("agentID"));
            dao.deleteAgent(agentId);
            forward = LIST_AGENT;
            request.setAttribute("agents", dao.getAllAgents());
        } 
        else if (action.equalsIgnoreCase("edit"))
        {
            // DEBUG - Location of activity
            System.out.println("Inside the EDIT action");
            
            forward = INSERT_OR_EDIT;
            int agentId = Integer.parseInt(request.getParameter("agentID"));
            Agent agent = dao.getAgentById(agentId);
            request.setAttribute("agent", agent);
        } 
        else if (action.equalsIgnoreCase("listAgent"))
        {
            // DEBUG - Location of activity
            System.out.println("Inside the listAgent action");
        
            forward = LIST_AGENT;
            request.setAttribute("agents", dao.getAllAgents());
        } 
	else 
	{
            // DEBUG - Location of activity
            System.out.println("Inside the Default action");
            
            forward = INSERT_OR_EDIT;
        }

             // DEBUG - Location of activity
            System.out.println(">>>> Agent - About to RequestDispatcher view."+ forward);
            
       RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {
        // DEBUG - Location of activity
        System.out.println("Inside the doPost section");
        
        Agent agent = new Agent();
        agent.setTitle(request.getParameter("title"));
        agent.setFirst(request.getParameter("first"));
        agent.setMi(request.getParameter("mi"));		
        agent.setLast(request.getParameter("last"));
        try 
        {
            Date hireDate = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("hireDate"));
            agent.setHireDate(hireDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }		
        agent.setHome_phone(request.getParameter("home_phone"));
        agent.setCell_phone(request.getParameter("cell_phone"));
        agent.setPager(request.getParameter("pager"));

        String agentID = request.getParameter("agentID");
        // DEBUG - Location of activity DID AGENT GET SELECTED FROM LIST
        System.out.println("###AGENT: The value of Agent ID is :" + agentID);

        if(agentID == null || agentID.isEmpty())
        {
            dao.addAgent(agent);
        }
        else
        {
            agent.setAgentID(Integer.parseInt(agentID));
            dao.updateAgent(agent);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_AGENT);
        request.setAttribute("agents", dao.getAllAgents());
        view.forward(request, response);
    }
}



