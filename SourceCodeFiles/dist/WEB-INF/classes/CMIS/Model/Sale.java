/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CMIS.Model;

/**
 *
 * @author Kaigh
 */
import java.util.Date;

public class Sale {

    private int saleID;
    private Double actualamt;
    private Date saledate;
    private int custID;
    private int agentID;
    private int homeID;
    private String contractID;


    public int getSaleID() 
    {
        return saleID;
    }

    public void setSaleID(int sl_ID) 
    {
        this.saleID = sl_ID;
    }

    public Double getActualamt() 
    {
        return actualamt;
    }

    public void setActualamt(Double amt) 
    {
        this.actualamt = amt;
    }

    public Date getSaledate() 
    {
        return saledate;
    }

    public void setSaledate(Date saledate) 
    {
        this.saledate = saledate;
    }

    public int getCustID() 
    {
        return custID;
    }

    public void setCustID(int c_ID) 
    {
        this.custID = c_ID;
    }
    
    public int getAgentID() 
    {
        return agentID;
    }

    public void setAgentID(int ag_ID) 
    {
        this.agentID = ag_ID;
    }

    public int getHomeID() 
    {
        return homeID;
    }

    public void setHomeID(int hm_ID) 
    {
        this.homeID = hm_ID;
    }

    public String getContractID()
    {
            return contractID;
    }

    public void setContractID(String contractID)
    {
            this.contractID = contractID;
    }
	
    @Override

    public String toString() 
    {
        return "Sale [saleID=" + String.valueOf(saleID) +  
		", actualamt=" + actualamt + ", saledate=" + saledate + ", custID=" + 
		String.valueOf(custID) + ", agentID=" + String.valueOf(agentID) +  "]";
    }   

}