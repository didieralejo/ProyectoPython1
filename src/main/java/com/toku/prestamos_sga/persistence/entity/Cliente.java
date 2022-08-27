package com.toku.prestamos_sga.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/***
 * @Data
 * Genera todos los set y get y metodos de clase y un constructor vacio o
 * para casos especiales variables final que se deben inicializar o variables con la
 * anotacion @NonNull variables que no pueden ser vacias
 */
@Data
@Entity
@Table (name ="clientes")
public class Cliente {

    @Id
    private String id;

    private String nombre;

    private String apellidos;

    private Long celular;

    private String direccion;

    @Column (name = "correo_electronico")
    private String correoElectronico;

    @OneToMany (mappedBy = "cliente")
    private List<Compra> compras;
}
