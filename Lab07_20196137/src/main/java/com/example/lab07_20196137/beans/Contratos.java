package com.example.lab07_20196137.beans;

public class Contratos {

    private String nombreCliente;
    private String nroDeContrato;
    private String estadoDelContrato;
    private int mesesEnEseEstado;
    private String divisa;
    private float expectedLoss;

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNroDeContrato() {
        return nroDeContrato;
    }

    public void setNroDeContrato(String nroDeContrato) {
        this.nroDeContrato = nroDeContrato;
    }

    public String getEstadoDelContrato() {
        return estadoDelContrato;
    }

    public void setEstadoDelContrato(String estadoDelContrato) {
        this.estadoDelContrato = estadoDelContrato;
    }

    public int getMesesEnEseEstado() {
        return mesesEnEseEstado;
    }

    public void setMesesEnEseEstado(int mesesEnEseEstado) {
        this.mesesEnEseEstado = mesesEnEseEstado;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public float getExpectedLoss() {
        return expectedLoss;
    }

    public void setExpectedLoss(float expectedLoss) {
        this.expectedLoss = expectedLoss;
    }
}
