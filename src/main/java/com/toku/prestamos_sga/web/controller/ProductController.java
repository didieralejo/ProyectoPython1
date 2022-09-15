package com.toku.prestamos_sga.web.controller;

import com.toku.prestamos_sga.domain.Product;
import com.toku.prestamos_sga.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    //ResponseEntity<> recibe dos parametros en el constructor, el body y
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    //El path de este se coloca entre llaves la variable que recibe el metodo
    //Al metodo se le coloca @PathVariable("el mismo nombre que se coloca en getmapping")
    //Al ejecutarlo seria /products/123
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int idCategoria){
        return productService.getByCategory(idCategoria)
                .map(productsList -> new ResponseEntity<>(productsList, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int idProducto){
        return productService.getProduct(idProducto)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/stock/{estado}/{cant}")
    public ResponseEntity<List<Product>> getScarseProducts(@PathVariable("cant") int cantidadStock,@PathVariable("estado") boolean estado){
        return productService.getScarseProducts(cantidadStock, estado)
                .map(productsList -> new ResponseEntity<>(productsList, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Para guardar o modificar @PostMapping
    //La entidad producto viaja en el body @RequestBody
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    //Para eliminar se usa @DeleteMapping
    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteByIdProducto(@PathVariable("id") int idProducto){
        if(productService.deleteByIdProducto(idProducto)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    public boolean delete (Product product){
        return productService.delete(product);
    }
}
