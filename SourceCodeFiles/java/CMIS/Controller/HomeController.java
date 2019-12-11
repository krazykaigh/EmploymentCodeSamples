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

import CMIS.DAO.HomeDAO;
import CMIS.Model.Home;


public class HomeController extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/home.jsp";
    private static String LIST_HOME = "/listHome.jsp";
    private HomeDAO dao;

    public HomeController() 
    {
        super();
        try {
            dao = new HomeDAO();
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
            
            int homeId = Integer.parseInt(request.getParameter("homeID"));
            dao.deleteHome(homeId);
            forward = LIST_HOME;
            request.setAttribute("homes", dao.getAllHomes());
        } 
        else if (action.equalsIgnoreCase("edit"))
        {
            // DEBUG - Location of activity
            System.out.println("Inside the EDIT action");
            
            forward = INSERT_OR_EDIT;
            int homeId = Integer.parseInt(request.getParameter("homeID"));
            Home home = dao.getHomeById(homeId);
            request.setAttribute("home", home);
        } 
        else if (action.equalsIgnoreCase("listHome"))
        {
            // DEBUG - Location of activity
            System.out.println("Inside the listHome action");
        
            forward = LIST_HOME;
            request.setAttribute("homes", dao.getAllHomes());
        } 
	else 
	{
            // DEBUG - Location of activity
            System.out.println("Inside the Default action");
            
            forward = INSERT_OR_EDIT;
        }
             // DEBUG - Location of activity
            System.out.println(">>>> Home -About to RequestDispatcher view."+ forward);

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
        
        Home home = new Home();
        home.setLot_size(request.getParameter("lot_size"));
        home.setLocation(request.getParameter("location"));		
        home.setModel_ID(request.getParameter("model_ID"));
        home.setPurchaseprice(Double.parseDouble(request.getParameter("purchaseprice")));
        home.setStreet(request.getParameter("street"));
        home.setCity(request.getParameter("city"));
        home.setState(request.getParameter("state"));
        home.setZipcode(request.getParameter("zipcode"));
        
        // DEBUG - Location of activity DID AGENT GET SELECTED FROM LIST
        System.out.println("ALERT: The value of HomeID is :" + home.getHomeID());

        String homeID = request.getParameter("homeID");
        // DEBUG - Location of activity DID AGENT GET SELECTED FROM LIST
        System.out.println("###HOME: The value of Home ID is :" + homeID);

        if(homeID == null || homeID.isEmpty())
        {
            dao.addHome(home);
        }
        else
        {
            home.setHomeID(Integer.parseInt(homeID));
            dao.updateHome(home);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_HOME);
        request.setAttribute("homes", dao.getAllHomes());
        view.forward(request, response);
    }
}
