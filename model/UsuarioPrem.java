package com.example.demo.model;
import com.example.demo.model.UsuarioAbs;
import com.example.demo.model.VehiculoAbs;
import com.example.demo.model.TipoPago;
import lombok.*;

@Getter
@ToString

public class UsuarioPrem extends UsuarioAbs {

    public UsuarioPrem(UUID id, String nombre, TipoPago tipoPago, double saldo) {
        super(id, nombre);
        this.tipoPago = tipoPago;
        this.saldo = saldo;
    }

    public void realizarPago(TipoPago tipoPago) {
        if (tipoPago == TipoPago.Tarjeta) {
            // Lógica para procesar el pago con tarjeta de crédito
        } else if (tipoPago == TipoPago.PAYPAL) {
            // Lógica para procesar el pago con PayPal
        } else if (tipoPago == TipoPago.SALDO) {
            // Lógica para procesar el pago con saldo
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
