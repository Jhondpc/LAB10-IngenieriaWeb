package com.example.lab10.beans;

public class Contratos {

    private String idCliente;
    private String nroDeContrato;
    private int estadoDelContrato;
    private int mesesEnEseEstado;
    private String divisa;

    public String getIdCliente() {return idCliente;}

    public void setIdCliente(String idCliente) {this.idCliente = idCliente;}

    public String getNroDeContrato() {
        return nroDeContrato;
    }

    public void setNroDeContrato(String nroDeContrato) {
        this.nroDeContrato = nroDeContrato;
    }

    public int getEstadoDelContrato() {
        return estadoDelContrato;
    }

    public void setEstadoDelContrato(int estadoDelContrato) {
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

}
