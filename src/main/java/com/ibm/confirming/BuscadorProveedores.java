package com.ibm.confirming;

import com.ibm.confirming.utils.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuscadorProveedores {

    private final long idCliente;
    private final List<Proveedor> listaProveedores;

    public BuscadorProveedores(int idCliente) {
        this.idCliente = idCliente;
        listaProveedores = new ArrayList<Proveedor>();
    }

    public List<Proveedor> getProveedores() throws SQLException {
        Connection cn = Conexion.conectar();
        String sql = "SELECT * from proveedores where id_cliente = '" + getIdCliente() + "'";

        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                long idProveedor = Long.parseLong(String.valueOf(rs.getObject("id_proveedor")));
                String nombre = String.valueOf(rs.getObject("nombre"));
                String fecha_alta = String.valueOf(rs.getObject("fecha_alta"));
                long idCliente = Long.parseLong(String.valueOf(rs.getObject("id_cliente")));
                listaProveedores.add(new Proveedor(idProveedor, nombre, getDate(fecha_alta), idCliente));
            }
            return listaProveedores;
        }catch (SQLException ex){
            Logger.getLogger(BuscadorProveedores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            cn.close();
        }
        return null;
    }

    private LocalDate getDate(String date) throws ParseException {
        //return new SimpleDateFormat("yyyy-mm-dd").parse(date);
        return LocalDate.parse(date);
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public long getIdCliente() {
        return idCliente;
    }

}
