package com.example.demo.model;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(of="id")
@ToString


public abstract class UsuarioAbs {
    private final UUID id;
    private String nombre;
    private TipoPago tipoPago;
    private double saldo;

    public UsuarioAbs(UUID id, String nombre) {
        this.id = (id != null) ? id : UUID.randomUUID();
        this.nombre = nombre;
    }
    public void metodoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

}
