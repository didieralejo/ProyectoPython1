package com.toku.prestamos_sga.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable //Contiene las dos llaves primarias que juntas seran la PK compuesta en la entity
public class CompraProductoPK implements Serializable {

    @Column (name = "id_compra")
    private Integer idCompra;

    @Column (name = "id_producto")
    private Integer idProducto;
}
