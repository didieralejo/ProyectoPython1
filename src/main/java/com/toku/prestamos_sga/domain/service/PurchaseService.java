package com.toku.prestamos_sga.domain.service;

import com.toku.prestamos_sga.domain.Purchase;
import com.toku.prestamos_sga.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getPurchaseByClientId(String clientId){
        return purchaseRepository.getPurchaseByClientId(clientId);
    }

    public Purchase save (Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
