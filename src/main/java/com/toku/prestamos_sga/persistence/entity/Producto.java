package com.toku.prestamos_sga.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data //Set y get
@Entity //Indicamos a Java que esta clase mapera la tabla Producto de la DB
@Table(name = "productos")  //Como en el nombre de la tabla y de la clase son diferentes se usa esta anotacion
public class Producto {

    @Id //El atributo representa el campo de PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrementable usando el campo PK como contador
    @Column (name = "id_producto") //Nnombre atributo y nombre campo diferente, su debe usar anotacion @Column
    private Integer idProducto;

    //Como el nombre del atributo es el mismo de la tabla, no se usa ninguna anotacion
    private String nombre;

    @Column(name ="id_categoria")
    private Integer idCategoria;

    @Column (name = "codigo_barras")
    private String codigoBarras;

    @Column (name = "precio_venta")
    private Double precioVenta;

    @Column(name ="cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    /**
     * Muchos productos tiene una categoria
     * se relaciona a la tabla categoria a traves del campo id_categoria
     * No se puede insertar, borrar o modificar una categoria a traves de la entidad producto
     */
    @ManyToOne
    @JoinColumn(name ="id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    @OneToMany (mappedBy = "producto")
    private List<CompraProducto> compras;
}
