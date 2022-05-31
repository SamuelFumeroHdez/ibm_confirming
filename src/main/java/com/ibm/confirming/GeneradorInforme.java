package com.ibm.confirming;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GeneradorInforme {

    private final List<Proveedor> listaProveedores;

    GeneradorInforme(List<Proveedor> listaProveedores){
        this.listaProveedores = listaProveedores;
    }

    public void generarInforme() throws IOException {
        if(this.listaProveedores.isEmpty()){
            System.out.println("El cliente no tiene proveedores asignados (NO se modificará el CSV si ya existe)");
        }else{
            FileWriter fileWriter = null;
            PrintWriter printWriter = null;

            try{
                fileWriter = new FileWriter("./proveedores.csv");
                printWriter = new PrintWriter(fileWriter);
                printWriter.println(generarCabecera());
                for(Proveedor proveedor : this.listaProveedores){
                    printWriter.println(generarLineaProveedor(proveedor));
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }finally {
                if(null != fileWriter){
                    fileWriter.close();
                }
            }

        }

    }

    public StringBuilder generarCabecera(){
        StringBuilder cabecera = new StringBuilder("");
        cabecera.append("ID_PROVEEDOR;");
        cabecera.append("NOMBRE;");
        cabecera.append("FECHA_ALTA;");
        cabecera.append("ID_CLIENTE");
        return cabecera;
    }

    public StringBuilder generarLineaProveedor(Proveedor proveedor){
        StringBuilder linea = new StringBuilder("");
        linea.append(proveedor.getIdProveedor() + ";");
        linea.append(proveedor.getNombre() + ";");
        linea.append(proveedor.getFechaAlta() + ";");
        linea.append(proveedor.getIdCliente());

        return linea;

    }
}
