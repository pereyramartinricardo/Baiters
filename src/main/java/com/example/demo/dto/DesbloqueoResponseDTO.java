package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DesbloqueoResponseDTO {
    private String vehiculoPatente;
    private double montoCobrado;
    private String mensaje;
}