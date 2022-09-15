package com.toku.prestamos_sga.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table (name ="compras")
public class Compra {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name ="id_compra")
    private Integer idCompra;

    @Column (name ="id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column (name = "medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;

    @ManyToOne
    @JoinColumn(name ="id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    //Le indicamos que realizaremos actualizciones en cascada entre la tabla compras y la lista de productos
    @OneToMany (mappedBy = "compra", cascade = {CascadeType.ALL})
    private List<CompraProducto> productos;
}
