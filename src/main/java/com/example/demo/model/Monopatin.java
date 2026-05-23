package com.example.demo.model;
import lombok.*;
@Getter
@ToString


public class Monopatin  extends VehiculoAbs {
    private boolean amortiguacion;

    public Monopatin(String patente, int bateria, double tarifa, boolean amortiguacion) {
        super(patente, bateria, tarifa);
        this.amortiguacion = amortiguacion;
    }
}

