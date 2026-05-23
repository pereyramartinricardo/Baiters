package com.example.demo.controller;

import com.example.demo.dto.DesbloqueoRequestDTO;
import com.example.demo.dto.DesbloqueoResponseDTO;
import com.example.demo.exception.BateriaInsuficiente;
import com.example.demo.exception.VehiculoNoEncontrado;
import com.example.demo.service.AlquilerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alquileres")
public class EcoRideController {

    private final AlquilerService alquilerService;

    public EcoRideController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    // Se usa GetMapping con RequestBody por requerimiento estricto de la consigna
    @GetMapping("/desbloquear")
    public ResponseEntity<?> desbloquearVehiculo(@RequestBody DesbloqueoRequestDTO request) {
        try {
            // Llama a la lógica de negocio estructurada secuencialmente
            DesbloqueoResponseDTO response = alquilerService.procesarDesbloqueo(request);
            return ResponseEntity.ok(response);
            
        } catch (VehiculoNoEncontrado | BateriaInsuficiente e) {
            // Intercepta las anomalías de negocio (Punto B) y devuelve un 400 Bad Request
            return ResponseEntity.badRequest().body(e.getMessage());
            
        } catch (Exception e) {
            // Manejo genérico por si falla el pago u otra cosa
            return ResponseEntity.internalServerError().body("Error interno del servidor: " + e.getMessage());
        }
    }
}