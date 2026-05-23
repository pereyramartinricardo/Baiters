package com.example.demo.model;

import lombok.*;
import java.util.UUID;

@Getter
@ToString

public class UsuarioPrem extends UsuarioAbs {
    private TipoPago tipoPago;
    private double saldo;

    public UsuarioPrem(UUID id, String nombre, TipoPago tipoPago, double saldo) {
        super(id, nombre);
        this.tipoPago = tipoPago;
        this.saldo = saldo;
    }

    public void realizarPago(TipoPago tipoPago) {
        if (tipoPago == TipoPago.TARJETA) {
            // Lógica para procesar el pago con tarjeta de crédito
        } else if (tipoPago == TipoPago.VIRTUAL) {
            // Lógica para procesar el pago con PayPal
        }
    }

    public double descontarTarifa(VehiculoAbs tarifa) {
        double saldoActual = this.saldo;

        double tarifaOriginal = tarifa.getTarifa();

        double descuento = tarifaOriginal * 0.15;

        double tarifaDescontada = tarifaOriginal - descuento;

        this.saldo = saldoActual - tarifaDescontada;

        return tarifaDescontada;
    }
}
