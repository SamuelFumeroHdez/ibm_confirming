package com.ibm.confirming.utils;

import java.sql.*;

public class Conexion {

    public static Connection conectar(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/ibm_confirming?useSSL=false", "root", "");
            return cn;
        }catch(SQLException e){
            System.err.println("Error en la conexión local " + e);
        }

        return null;
    }


}
