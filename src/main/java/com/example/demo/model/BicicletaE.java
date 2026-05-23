package com.example.demo.model;

import lombok.*;
@Getter
@ToString

public class BicicletaE extends VehiculoAbs {
    private double capacidad;

    public BicicletaE(String patente, int bateria, double tarifa, double capacidad) {
        super(patente, bateria, tarifa);
        this.capacidad = capacidad;
    }
}
