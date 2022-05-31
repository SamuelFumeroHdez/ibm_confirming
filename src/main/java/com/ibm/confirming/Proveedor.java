package com.ibm.confirming;

import java.time.LocalDate;
import java.util.Date;

public class Proveedor {

    private long idProveedor;
    private String nombre;
    private LocalDate fechaAlta;
    private long idCliente;

    public Proveedor(long idProveedor, String nombre, LocalDate fechaAlta, long idCliente) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.idCliente = idCliente;
    }

    public long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "idProveedor=" + idProveedor +
                ", nombre='" + nombre + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", idCliente=" + idCliente +
                '}';
    }
}
