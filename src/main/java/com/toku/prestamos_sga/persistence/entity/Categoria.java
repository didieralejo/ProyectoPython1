package com.toku.prestamos_sga.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@Data
@Entity
@Table (name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_categoria")
    private Integer idCategoria;

    private String descripcion;

    private String estado;

    /**
     * Una categoria tiene muchos productos, se crea una lista
     * y mapea a traves de la variable que se creo en la clase producto para manejar la relacion *categoria*
     */
    @OneToMany (mappedBy = "categoria")
    private List<Producto> productos;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
