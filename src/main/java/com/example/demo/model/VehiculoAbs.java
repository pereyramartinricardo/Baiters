package com.example.demo.model;
import lombok.*;
@Getter
@ToString

public abstract class VehiculoAbs {
    private final String patente;
    private final int bateria;
    private double tarifa;

    public VehiculoAbs(String patente, int bateria, double tarifa) {
        this.patente = patente;
        this.bateria = bateria;
        this.tarifa = tarifa;
    }
}
