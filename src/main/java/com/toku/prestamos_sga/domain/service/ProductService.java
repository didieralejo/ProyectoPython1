package com.toku.prestamos_sga.domain.service;

import com.toku.prestamos_sga.domain.Product;
import com.toku.prestamos_sga.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<List<Product>> getByCategory(int idCategoria){
        return productRepository.getByCategory(idCategoria);
    }

    public Optional<Product> getProduct(int idProducto){
        return productRepository.getProduct(idProducto);
    }

    public Optional<List<Product>> getScarseProducts(int cantidadStock, boolean estado){
        return productRepository.getScarseProducts(cantidadStock, estado);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean deleteByIdProducto(int idProducto){
        return getProduct(idProducto).map(product -> {
            productRepository.deleteByIdProducto(idProducto);
            return true;
        }).orElse(false);

    }

    public boolean delete (Product product){
        if(getProduct(product.getProductId()).isPresent()){
            productRepository.delete(product);
            return true;
        }else{
            return false;
        }
    }


}
