package com.example.demo.model;
import com.example.demo.model.VEhiculoAbs;


public class Monopatin  extends VehiculoAbs {
    private boolean amortiguacion;
    


    public Monopatin(String patente, int bateria, double tarifa, boolean amortiguacion) {
        super(patente, bateria, tarifa);
        this.amortiguacion = amortiguacion;
    }
}

