/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mario
 */
public class Conexion {
    
    private static  String base="inventario";
    private static  String user="root";
    private static String password="root";
    private static String url="jdbc:mysql://localhost:3306/"+base;
    private static Connection con=null;
    
    public static Connection getConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(url,user,password);
            System.out.println("Se conecto correctamente");
        } catch (ClassNotFoundException ex) {
            
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return con; 
    }
}
