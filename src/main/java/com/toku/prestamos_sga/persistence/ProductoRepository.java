package com.toku.prestamos_sga.persistence;

import com.toku.prestamos_sga.persistence.crud.ProductoCrudRepository;
import com.toku.prestamos_sga.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Indicamos que esta clase esta interactuando con BD
public class ProductoRepository {

    //Objeto de la interfaz
    private ProductoCrudRepository productoCrudRepository;

    //Metodo para recuperar los productos de la base de datos
    public List<Producto> gelAll(){
        //productoCrudRepository.findAll() retorna Iterable, se debe casting (List<Producto>)
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria (int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Producto getByCodigoBarras(String codigoBarras){
        return productoCrudRepository.findBycodigoBarras(codigoBarras);
    }

    public Optional<List<Producto>> getProductosLimitieEnStock (int cantidadStock, boolean estado){
        return productoCrudRepository.findByCantidadStockLessThanAnAndEstado(cantidadStock, estado);
    }

    //Buscar producto por id
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    //Guadar producto
    public Producto saveProduct (Producto producto){
        return productoCrudRepository.save(producto);
    }

    //Eliminar teniendo el objeto completo
    public void deleteProduct (Producto producto){
        productoCrudRepository.delete(producto);
    }

    //Eliminar por id
    public void deleteProductById (int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }



}
