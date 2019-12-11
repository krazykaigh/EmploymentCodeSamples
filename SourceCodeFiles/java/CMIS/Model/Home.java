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

public class Home {

    private int homeID;
    private String lot_size;
    private String location;
    private String model_ID;
    private Double purchaseprice;
    private String street;
    private String city;
    private String state;
    private String zipcode;

    public int getHomeID() 
    {
        return homeID;
    }

    public void setHomeID(int hm_ID) 
    {
        this.homeID = hm_ID;
    }

    public String getLot_size() 
    {
        return lot_size;
    }

    public void setLot_size(String lSize) 
    {
        this.lot_size = lSize;
    }

    public String getLocation() 
    {
        return location;
    }
	
    public void setLocation(String locale) 
    {
        this.location = locale;
    }

    public String getModel_ID() 
    {
        return model_ID;
    }

    public void setModel_ID(String modID) 
    {
        this.model_ID = modID;
    }
	
    public Double getPurchaseprice() 
    {
        return purchaseprice;
    }

    public void setPurchaseprice(Double pPrice) 
    {
        this.purchaseprice = pPrice;
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


    @Override

    public String toString() 
    {
        return "Home [homeID=" + String.valueOf(homeID) +  
		", lot_size=" + lot_size + ", location=" + location + ", model_ID=" + model_ID +
		", purchaseprice=" + purchaseprice + ", street=" + street + ", city=" + city + ", state=" + state +
		", zipcode=" + zipcode + "]";
    }   

}