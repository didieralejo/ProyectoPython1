package com.toku.prestamos_sga.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "compras_productos")
public class CompraProducto {

    @EmbeddedId //Llave primaria compuesta por la clase
    private CompraProductoPK id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name ="id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name ="id_producto", insertable = false, updatable = false)
    private Producto producto;
}
