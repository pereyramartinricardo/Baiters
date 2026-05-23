package com.example.demo.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class DesbloqueoRequestDTO {
    private UUID idUsuario;
    private String patente;
    private String metodoPago; // "TARJETA" o "VIRTUAL"
}