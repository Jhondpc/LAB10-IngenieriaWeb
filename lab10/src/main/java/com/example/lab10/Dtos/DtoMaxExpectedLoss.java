package com.example.lab10.Dtos;

public class DtoMaxExpectedLoss {
    private String nombreCliente;
    private float maxExpectedLoss;

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public float getMaxExpectedLoss() {
        return maxExpectedLoss;
    }

    public void setMaxExpectedLoss(float maxExpectedLoss) {
        this.maxExpectedLoss = maxExpectedLoss;
    }
}
