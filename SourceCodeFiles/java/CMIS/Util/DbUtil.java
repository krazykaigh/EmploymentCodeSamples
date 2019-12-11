/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CMIS.Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Kaigh
 */
public class DbUtil 
{
    private static Connection connection = null;
    public static Connection getConnection() throws IOException, SQLException 
    {
        if (connection != null)
        return connection;

        else 
        {
            try 
            {
                Properties prop = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);connection = DriverManager.getConnection(url, user, password);
            }  
            catch (ClassNotFoundException | SQLException e) 
            {
                e.printStackTrace();
            } 
            catch (FileNotFoundException e) 
            {
                e.printStackTrace();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
            return connection;
        }
    }
 
}
