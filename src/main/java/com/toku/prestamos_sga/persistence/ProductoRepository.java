package com.toku.prestamos_sga.persistence;

import com.toku.prestamos_sga.domain.Product;
import com.toku.prestamos_sga.domain.repository.ProductRepository;
import com.toku.prestamos_sga.persistence.crud.ProductoCrudRepository;
import com.toku.prestamos_sga.persistence.entity.Producto;
import com.toku.prestamos_sga.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Indicamos que esta clase esta interactuando con BD
/**
 * Cuando se implemente ProductRepository, el repositorio ProductoRepository queda
 * enfocado al DOMAIN y no ha una tabla puntual PRODUCTO
 */
public class ProductoRepository implements ProductRepository{

    /**
     * Objeto de la interfaz
     * ProductoCrudRepository productoCrudRepository nunca fue inicializado, por tal motivo su valor es null
     * Al invocar cualquier método productoCrudRepository.XXXX, estaria solicitando un metodo a un objeto null y
     * se genera el NullPointerException
     * Vamos a ceder el control a Spring para que el gestione, cree e instancie el objeto (IoC) a traves de
     * @Autowired
     * Se debe asegurar que el objeto con @Autowired, tenga una notacion spring o sea un objeto spring
     */
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    //Variable para el mapeo
    @Autowired
    private ProductMapper productMapper ;

    @Override
    //Lista de todos los productos
    public List<Product> getAll(){
        //productoCrudRepository.findAll() retorna Iterable, se debe casting (List<Producto>)
        List<Producto> productoList = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productoList);
    }

    @Override
    //Trae una lista de productos por categoria
    public Optional<List<Product>> getByCategory(int idCategoria) {
        List<Producto> productoList = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
        return Optional.of(productMapper.toProducts(productoList));
    }

    @Override
    /**
     * Busca los productos escasos y que esten activos
     * productoList.map(prods -> productMapper.toProducts(prods));
     * Permite sacar del Optional productoList, la List<Producto> y se almacena en prods y luego se envia a
     * productMapper.toProducts(prods)
     */
    public Optional<List<Product>> getScarseProducts(int cantidadStock, boolean estado) {
        Optional<List<Producto>> productoList = productoCrudRepository.findByCantidadStockLessThanAnAndEstado(cantidadStock, estado);
        return productoList.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    //Buscar producto por id
    public Optional<Product> getProduct(int idProducto) {
        Optional<Producto> producto =  productoCrudRepository.findById(idProducto);
        return producto.map(prod -> productMapper.toProduct(prod));
    }

    @Override
    //Guadar producto
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    //Eliminar por id
    public void deleteByIdProducto(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }

    @Override
    //Eliminar teniendo el objeto completo
    public void delete(Product product) {
        productoCrudRepository.delete(productMapper.toProducto(product));
    }

    public Producto getByCodigoBarras(String codigoBarras){
        return productoCrudRepository.findBycodigoBarras(codigoBarras);
    }

}
