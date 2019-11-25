package com.seehope.dao.impl.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtils {
       private static ComboPooledDataSource data =new ComboPooledDataSource();
       public static Connection getConnection() throws SQLException{
    	   return data.getConnection();
       }
       public static void close(Connection con,PreparedStatement pst,ResultSet rs) throws SQLException{
    	   if(rs!=null){
    		   rs.close();
    	   }
    	   if(pst!=null)
    	   {
    		   pst.close();
    	   }
    	   if(con!=null){
    		   con.close();
    	   }
       }
}
