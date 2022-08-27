package com.toku.prestamos_sga.persistence.crud;

import com.toku.prestamos_sga.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Este es la interface CRUD de la tabla producto
 * CrudRepository<CLASE QUE MAPEA LA TABLA, TIPO DATO DE LA PK EN LA CLASE>
 * Clase producto y tipo de dato INTEGER
 */
//Implemente los metodos por defecto de la interface CrudRepository y permite agregar nuevos
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    /**
     * Metodo para buscar producto por categoria
     * findBy -> Select * from table Producto
     * campo por el cual se va a bucar -> usar camelCase ->idCategoria se cambia IdCategoria
     * Con lo anterior se crea el where where = parametro
     * Campo de buscqueda debe ser igual a como se creo en la clase Producto
     * Retorna una lista de productos
     */
    List<Producto> findByIdCategoriaOrderByNombreAsc (int idCategoria);

    @Query (value = "SELECT * FROM productos WHERE codigo_barras =?", nativeQuery = true)
    Producto findBycodigoBarras (String codigoBarras);

    /**
     * Select * from table Producto where cantidadStock < cantidadStock and estado = estado
     * @param cantidadStock
     * @param estado
     * @return Optional<List<Producto>>
     */
    Optional<List<Producto>> findByCantidadStockLessThanAnAndEstado(int cantidadStock, boolean estado);
}
