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

public class Customer {

    private int custID;
    private String first;
    private String mi;
    private String last;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String home_phone;
    private Date dob;
    private String profession;
    private String referrer;
    private int agentID;

    public int getCustID() 
    {
        return custID;
    }

    public void setCustID(int cst_ID) 
    {
        this.custID = cst_ID;
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
	
	public String getStreet()
	{
		return street;
	}
	
	public void setStreet(String street)
	{
		this.street = street;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public String getZipcode()
	{
		return zipcode;
	}
	
	public void setZipcode(String zip)
	{
		this.zipcode = zip;
	}

     public String getHome_phone() 
    {
        return home_phone;
    }

    public void setHome_phone(String HPhone) 
    {
        this.home_phone = HPhone;
    }


    public Date getDob() 
    {
        return dob;
    }

    public void setDob(Date dateofbirth) 
    {
        this.dob = dateofbirth;
    }

    public String getProfession() 
    {
        return profession;
    }

    public void setProfession(String profession) 
    {
        this.profession = profession;
    }

    public String getReferrer() 
    {
        return referrer;
    }

    public void setReferrer(String Referrer) 
    {
        this.referrer = referrer;
    }

    public int getAgentID() 
    {
        return agentID;
    }

    public void setAgentID(int ag_ID) 
    {
        this.agentID = ag_ID;
    }

    @Override

    public String toString() 
    {
        return "Customer [custID=" + String.valueOf(custID) +  
		", first=" + first + ", mi=" + mi + ", last=" + last +
		", street=" + street + ", city=" + city + ", state=" + state +
		", zipcode=" + zipcode + ", home_phone=" + home_phone +
		", DOB=" + dob + ", profession=" + profession + 
                ", referrer=" + referrer + ", agentID=" + String.valueOf(agentID) + "]";
    }   


}