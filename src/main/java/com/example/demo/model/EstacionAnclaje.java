package com.example.demo.model;

import java.util.List;
import lombok.*;

@Getter
@ToString

public class EstacionAnclaje {
    private final String nombre;
    private List<VehiculoAbs> vehiculosDisponibles;

    public EstacionAnclaje(String nombre, List<VehiculoAbs> vehiculosDisponibles) {
        this.nombre = nombre;
        this.vehiculosDisponibles = vehiculosDisponibles;
    }
}
