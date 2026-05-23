package com.example.demo.exception;

public class VehiculoNoEncontrado extends RuntimeException {
    public VehiculoNoEncontrado(String patente) {
        super("Vehículo no encontrado.");
    }

}
