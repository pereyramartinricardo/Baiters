package com.example.demo.service;

import com.example.demo.dto.DesbloqueoRequestDTO;
import com.example.demo.dto.DesbloqueoResponseDTO;
import com.example.demo.exception.BateriaInsuficiente;
import com.example.demo.exception.VehiculoNoEncontrado;
import com.example.demo.model.*;
import com.example.demo.payment.ProcesadorPago;
import com.example.demo.payment.ProcesadorPagoFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AlquilerService {

    private List<EstacionAnclaje> estaciones = new ArrayList<>();
    private List<UsuarioAbs> usuarios = new ArrayList<>();
    
    private final ProcesadorPagoFactory pagoFactory;

    public AlquilerService(ProcesadorPagoFactory pagoFactory) {
        this.pagoFactory = pagoFactory;
    }

    public DesbloqueoResponseDTO procesarDesbloqueo(DesbloqueoRequestDTO request) {
        
        UsuarioAbs usuario = buscarUsuarioPorId(request.getIdUsuario());
        if (usuario == null) {
            throw new RuntimeException("Usuario no registrado en el sistema.");
        }

        VehiculoAbs vehiculo = buscarVehiculoPorPatente(request.getPatente());
        if (vehiculo == null) {
            throw new VehiculoNoEncontrado(request.getPatente()); // Tu excepción personalizada
        }

        if (vehiculo.getBateria() < 15) {
            throw new BateriaInsuficiente(request.getPatente()); // Tu excepción personalizada
        }

        double importeFinal = vehiculo.getTarifa();
        
        if (usuario instanceof UsuarioPrem) {
            // Aplicar 15% de descuento fijo para Premium
            importeFinal = importeFinal - (importeFinal * 0.15);
        }

        ProcesadorPago procesadorPago = pagoFactory.obtenerProcesador(request.getMetodoPago());

        procesadorPago.procesarCobro(importeFinal);

        return new DesbloqueoResponseDTO(
                vehiculo.getPatente(), 
                importeFinal, 
                "Desbloqueo exitoso."
        );
    }

    // --- BÚSQUEDAS ITERATIVAS STRICTAS (For-each) ---

    private VehiculoAbs buscarVehiculoPorPatente(String patente) {
        for (EstacionAnclaje estacion : estaciones) {
            for (VehiculoAbs v : estacion.getVehiculosDisponibles()) {
                if (v.getPatente().equalsIgnoreCase(patente)) {
                    return v;
                }
            }
        }
        return null;
    }

    private UsuarioAbs buscarUsuarioPorId(UUID idUsuario) {
        for (UsuarioAbs u : usuarios) {
            if (u.getId().equals(idUsuario)) {
                return u;
            }
        }
        return null;
    }
    
    public void cargarDatosDePrueba(UsuarioAbs u, EstacionAnclaje e) {
        this.usuarios.add(u);
        this.estaciones.add(e);
    }
}