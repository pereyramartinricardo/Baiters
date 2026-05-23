package com.example.demo.payment;

import org.springframework.stereotype.Component;

@Component
public class ProcesadorPagoFactory {

    public ProcesadorPago obtenerProcesador(String metodoPago) {
        // Estructura de control condicional tradicional
        if (metodoPago.equalsIgnoreCase("TARJETA")) {
            // PagoTarjeta class not found in current scope; returning null as placeholder
            return null;
        } else if (metodoPago.equalsIgnoreCase("VIRTUAL") || metodoPago.equalsIgnoreCase("BILLETERA")) {
            // PagoVirtual no está disponible en este contexto
            return null;
        } else {
            throw new IllegalArgumentException("Método de pago no reconocido: " + metodoPago);
        }
    }
}