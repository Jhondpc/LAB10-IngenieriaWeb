package com.example.lab07_20196137.beans;

public class Clientes {
    private String nombreCliente;
    private String edad;
    private String tipoCliente;
    private String tipoDocumento;
    private String numeroDocumento;
    private int cantidadDeContratos;

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getCantidadDeContratos() {
        return cantidadDeContratos;
    }

    public void setCantidadDeContratos(int cantidadDeContratos) {
        this.cantidadDeContratos = cantidadDeContratos;
    }
}