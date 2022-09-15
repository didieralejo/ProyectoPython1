package com.toku.prestamos_sga.domain.repository;

import com.toku.prestamos_sga.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    //lista de todas las compras
    List<Purchase> getAll();

    //Lista de compras por un cliente en particular
    //Se usa Optional porque puede que la consulta retorne vacia
    Optional<List<Purchase>> getPurchaseByClientId(String clientId);

    //Guardar compra
    Purchase save (Purchase purchase);
}
