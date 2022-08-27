package com.toku.prestamos_sga.domain.repository;

import com.toku.prestamos_sga.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * Cualquier repositorio que quiera trabajar con productos debe
 * implementar los siguientes métodos
 */
public interface ProductRepository {
    //Regla del dominio, cuando cualquier repositorio quiera acceder a la tabla producto de la BD.

    List<Product> getAll(); // Retornar todos los prodyctos
    Optional<List<Product>> getByCategory(int idCategoria); //Retorna lista de procdcutos por id_categoria
    Optional<List<Product>> getScarseProducts(int cantidadStock, boolean estado); //Retorna lista de productos escasos
    Optional<Product> getProduct(int idProducto); //Retorna el producto dado su id
    Product save(Product product); //Guardar producto
    void deleteByIdProducto(int idProducto); //Elimina producto por idProducto
    void delete (Product product); //Elimina producto enviando objeto producto

}
