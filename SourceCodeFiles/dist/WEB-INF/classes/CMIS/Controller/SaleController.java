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

import CMIS.DAO.SaleDAO;
import CMIS.Model.Sale;


public class SaleController extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/sale.jsp";
    private static String LIST_SALE = "/listSale.jsp";
    private static String SALE_RPT = "/saleInfo.jsp";
    private SaleDAO dao;

    public SaleController() 
    {
        super();
        try {
            dao = new SaleDAO();
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
            
            int saleId = Integer.parseInt(request.getParameter("saleID"));
            dao.deleteSale(saleId);
            forward = LIST_SALE;
            request.setAttribute("sales", dao.getAllSales());
        } 
        else if (action.equalsIgnoreCase("edit"))
        {
            // DEBUG - Location of activity
            System.out.println("Inside the EDIT action");
            
            forward = INSERT_OR_EDIT;
            int saleId = Integer.parseInt(request.getParameter("saleID"));
            Sale sale = dao.getSaleById(saleId);
            request.setAttribute("sale", sale);
        } 
        else if (action.equalsIgnoreCase("listSale"))
        {
            // DEBUG - Location of activity
            System.out.println("Inside the listSale action");
        
            forward = LIST_SALE;
            request.setAttribute("sales", dao.getAllSales());
        } 
        else if (action.equalsIgnoreCase("viewSale"))
        {
            // DEBUG - Location of activity
            System.out.println("Inside the viewSale action");
        
            forward = SALE_RPT;
            request.setAttribute("saleRpt", dao.getSalesInfo());
        } 
	else 
	{
            // DEBUG - Location of activity
            System.out.println("Inside the Default action");
            
            forward = INSERT_OR_EDIT;
        }
             // DEBUG - Location of activity
            System.out.println(">>>> Sale -About to RequestDispatcher view."+ forward);

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
        
        Sale sale = new Sale();
        sale.setActualamt(Double.parseDouble(request.getParameter("actualamt")));
        try 
        {
            Date dateofsale = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("saledate"));
            sale.setSaledate(dateofsale);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }		
        sale.setCustID(Integer.parseInt(request.getParameter("custID")));
        sale.setAgentID(Integer.parseInt(request.getParameter("agentID")));
        sale.setHomeID(Integer.parseInt(request.getParameter("homeID")));
        sale.setContractID(request.getParameter("contractID"));
        
        // DEBUG - Location of activity DID AGENT GET SELECTED FROM LIST
        System.out.println("ALERT: The value of CustID is :" + sale.getCustID());

        System.out.println("ALERT: The value of AgentID is :" + sale.getAgentID());

        System.out.println("ALERT: The value of HomeID is :" + sale.getHomeID());
        String saleID = request.getParameter("saleID");

        // DEBUG - Location of activity DID AGENT GET SELECTED FROM LIST
        System.out.println("###CUSTOMER: The value of Sale ID is :" + saleID);

        if(saleID == null || saleID.isEmpty())
        {
            dao.addSale(sale);
        }
        else
        {
            sale.setSaleID(Integer.parseInt(saleID));
            dao.updateSale(sale);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_SALE);
        request.setAttribute("sales", dao.getAllSales());
        view.forward(request, response);
    }
}
