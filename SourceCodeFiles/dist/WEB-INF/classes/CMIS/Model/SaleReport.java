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
public class SaleReport 
{
    private int totalSales;
    private double salesSum;
    private double salesAvg;
    
    public SaleReport()
    {
    }
    
    public int getTotalSales()
    {
        return this.totalSales;
    }
    public void setTotalSales(int totSales)
    {
        this.totalSales = totSales;
    }
    
    public double getSalesSum()
    {
        return this.salesSum;
    }
    public void setSalesSum(double salesAdd)
    {
        this.salesSum = salesAdd;
    }
    
    public double getSalesAvg()
    {
        return this.salesAvg;
    }
    public void setSalesAvg(double saleAvg)
    {
        this.salesAvg = saleAvg;
    }
    
}
