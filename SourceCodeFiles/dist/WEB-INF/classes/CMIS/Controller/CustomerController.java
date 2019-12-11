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

import CMIS.DAO.CustomerDAO;
import CMIS.Model.Customer;


public class CustomerController extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/customer.jsp";
    private static String LIST_CUSTOMER = "/listCustomer.jsp";
    private CustomerDAO dao;

    public CustomerController() 
    {
        super();
        try {
            dao = new CustomerDAO();
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
            
            int custId = Integer.parseInt(request.getParameter("custID"));
            dao.deleteCustomer(custId);
            forward = LIST_CUSTOMER;
            request.setAttribute("customers", dao.getAllCustomers());
        } 
        else if (action.equalsIgnoreCase("edit"))
        {
            // DEBUG - Location of activity
            System.out.println("Inside the EDIT action");
            
            forward = INSERT_OR_EDIT;
            int custId = Integer.parseInt(request.getParameter("custID"));
            Customer customer = dao.getCustomerById(custId);
            request.setAttribute("customer", customer);
        } 
        else if (action.equalsIgnoreCase("listCustomer"))
        {
            // DEBUG - Location of activity
            System.out.println("Inside the listCustomer action");
        
            forward = LIST_CUSTOMER;
            request.setAttribute("customers", dao.getAllCustomers());
        } 
	else 
	{
            // DEBUG - Location of activity
            System.out.println("Inside the Default action");
            
            forward = INSERT_OR_EDIT;
        }
             // DEBUG - Location of activity
            System.out.println(">>>> Customer -About to RequestDispatcher view."+ forward);

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
        
        Customer customer = new Customer();
        customer.setFirst(request.getParameter("first"));
        customer.setMi(request.getParameter("mi"));		
        customer.setLast(request.getParameter("last"));
        customer.setStreet(request.getParameter("street"));
        customer.setCity(request.getParameter("city"));
        customer.setState(request.getParameter("state"));
        customer.setZipcode(request.getParameter("zipcode"));
        customer.setHome_phone(request.getParameter("home_phone"));
        try 
        {
            Date dateofbirth = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
            customer.setDob(dateofbirth);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }		
        customer.setProfession(request.getParameter("profession"));
        customer.setReferrer(request.getParameter("referrer"));
        customer.setAgentID(Integer.parseInt(request.getParameter("agentID")));
        // RRE_Agent
        // DEBUG - Location of activity DID AGENT GET SELECTED FROM LIST
        System.out.println("ALERT: The value of AgentID is :" + customer.getAgentID());

        String custID = request.getParameter("custID");
        // DEBUG - Location of activity DID AGENT GET SELECTED FROM LIST
        System.out.println("###CUSTOMER: The value of Customer ID is :" + custID);

        if(custID == null || custID.isEmpty())
        {
            dao.addCustomer(customer);
        }
        else
        {
            customer.setCustID(Integer.parseInt(custID));
            dao.updateCustomer(customer);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_CUSTOMER);
        request.setAttribute("customers", dao.getAllCustomers());
        view.forward(request, response);
    }
}
