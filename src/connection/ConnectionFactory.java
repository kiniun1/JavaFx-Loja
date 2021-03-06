/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1171535233
 */
public class ConnectionFactory 
{
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/loja?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "levimarcos17";
    //useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC [root on Default schema]"
    
    public static Connection getConnection()
    {
        try 
        {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException | SQLException ex) 
        {
            throw new RuntimeException("Erro na conexão",ex);
        }
    }
    
    public static void closeConnection(Connection con)
    {
        try 
        {
            if(con != null)
            {
                con.close();
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement st)
    {
        closeConnection(con);
        try 
        {
            if(st != null)
            {
                st.close();
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement st, ResultSet r)
    {
        closeConnection(con,st);
        try 
        {
            if(r != null)
            {
                r.close();
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}