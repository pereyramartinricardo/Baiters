package com.example.demo.model;

import com.example.demo.model.VehiculoAbs;

public class BicicletaE extends VehiculoAbs {
    private double capacidad;

    public BicicletaE(String patente, int bateria, double tarifa, double capacidad) {
        super(patente, bateria, tarifa);
        this.capacidad = capacidad;
    }

}
