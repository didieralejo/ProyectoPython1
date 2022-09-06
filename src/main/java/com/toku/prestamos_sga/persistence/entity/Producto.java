package com.toku.prestamos_sga.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@Data //Set y get
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

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<CompraProducto> getCompras() {
        return compras;
    }

    public void setCompras(List<CompraProducto> compras) {
        this.compras = compras;
    }
}
