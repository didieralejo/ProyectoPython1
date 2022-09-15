package com.toku.prestamos_sga.persistence;

import com.toku.prestamos_sga.domain.Purchase;
import com.toku.prestamos_sga.domain.repository.PurchaseRepository;
import com.toku.prestamos_sga.persistence.crud.CompraCrudRepository;
import com.toku.prestamos_sga.persistence.entity.Compra;
import com.toku.prestamos_sga.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getPurchaseByClientId(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> purchaseMapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        //La informacion se debe guardar en cascada, es decir
        //Compra conoce los prodcutos y los productos saben a que compra pertenecen
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
    }
}
