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

public class Agent {

    private int agentID;
    private String title;
    private String first;
    private String mi;
    private String last;
    private Date hireDate;
    private String home_phone;
    private String cell_phone;
    private String pager;

    public int getAgentID() 
    {
        return agentID;
    }

    public void setAgentID(int ag_ID) 
    {
        this.agentID = ag_ID;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String titled) 
    {
        this.title = titled;
    }
	
    public String getFirst() 
    {
        return first;
    }

    public void setFirst(String f_Name) 
    {
        this.first = f_Name;
    }

    public String getMi() 
    {
        return mi;
    }
	
    public void setMi(String midinit) 
    {
        this.mi = midinit;
    }

    public String getLast() 
    {
        return last;
    }

    public void setLast(String l_Name) 
    {
        this.last = l_Name;
    }

    public Date getHireDate() 
    {
        return hireDate;
    }

    public void setHireDate(Date hired) 
    {
        this.hireDate = hired;
    }

    public String getHome_phone() 
    {
        return home_phone;
    }

    public void setHome_phone(String HPhone) 
    {
        this.home_phone = HPhone;
    }

    public String getCell_phone() 
    {
        return cell_phone;
    }

    public void setCell_phone(String CPhone) 
    {
        this.cell_phone = CPhone;
    }

    public String getPager() 
    {
        return pager;
    }

    public void setPager(String Pager) 
    {
        this.pager = Pager;
    }

    @Override

    public String toString() 
    {
        return "User [agentID=" + String.valueOf(agentID) + ", title=" + title + 
		", first=" + first + ", mi=" + mi + ", last=" 
		+ last +", hireDate=" + hireDate + ", home_phone=" + home_phone 
		+ ", cell_phone=" + cell_phone + ", pager=" + pager +"]";
    }   
}