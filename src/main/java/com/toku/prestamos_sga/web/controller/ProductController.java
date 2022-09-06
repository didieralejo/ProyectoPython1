package com.toku.prestamos_sga.web.controller;

import com.toku.prestamos_sga.domain.Product;
import com.toku.prestamos_sga.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador web de api rest @RestController
 * @RequestMapping indica el PATH en el que va a aceptar las peticiones realizadas
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //@GetMapping Expone el servicio a la web como tipo GET (solo consulta, obtener info)
    //Recibe como parametro el path
    //Al ejecutarlo seria /products/all
    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    //El path de este se coloca entre llaves la variable que recibe el metodo
    //Al metodo se le coloca @PathVariable("el mismo nombre que se coloca en getmapping")
    //Al ejecutarlo seria /products/123
    @GetMapping("/category/{id}")
    public Optional<List<Product>> getByCategory(@PathVariable("id") int idCategoria){
        return productService.getByCategory(idCategoria);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int idProducto){
        return productService.getProduct(idProducto);
    }

    @GetMapping("/stock/{estado}/{cant}")
    public Optional<List<Product>> getScarseProducts(@PathVariable("cant") int cantidadStock,@PathVariable("estado") boolean estado){
        return productService.getScarseProducts(cantidadStock, estado);
    }

    //Para guardar o modificar @PostMapping
    //La entidad producto viaja en el body @RequestBody
    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    //Para eliminar se usa @DeleteMapping
    @DeleteMapping("/del/{id}")
    public boolean deleteByIdProducto(@PathVariable("id") int idProducto){
        return productService.deleteByIdProducto(idProducto);
    }

    public boolean delete (Product product){
        return productService.delete(product);
    }
}
