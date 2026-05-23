package com.example.demo.model;

import java.util.UUID;
import lombok.*;
@Getter
@ToString
public class UsuarioEstandar extends UsuarioAbs {
    private TipoPago tipoPago;
    private double saldo;

    public UsuarioEstandar(UUID id,String nombre, TipoPago tipoPago, double saldo) {
        super(id, nombre);
        this.tipoPago = tipoPago;
        this.saldo = saldo;
    }
    public double realizarPago(TipoPago tipoPago)
    {
        if (this.tipoPago == TipoPago.TARJETA) {
            return 0.0; // No se realiza ningún cargo para usuarios con tarjeta
        } else if (this.tipoPago == TipoPago.VIRTUAL) {
            double saldoActual = this.saldo;
            double tarifa = 0.0; // Aquí deberías obtener la tarifa del vehículo que se está utilizando

            if (saldoActual >= tarifa) {
                this.saldo = saldoActual - tarifa; // Descontar la tarifa del saldo del usuario
                return tarifa; // Retornar el monto descontado
            } else {
                throw new RuntimeException("Saldo insuficiente para realizar el pago.");
            }
        } else {
            throw new RuntimeException("Tipo de pago no válido.");
        }
     
    }
    
}
