package com.ibm.confirming;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        if(args.length != 1){
            System.out.println("Uso: programa.jar [id_cliente]");
            System.exit(0);
        }

        BuscadorProveedores buscadorProveedores = new BuscadorProveedores(Integer.parseInt(args[0]));
        GeneradorInforme generadorInforme = new GeneradorInforme(buscadorProveedores.getProveedores());
        generadorInforme.generarInforme();


    }
}
