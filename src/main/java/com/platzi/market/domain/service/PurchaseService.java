package com.platzi.market.domain.service;

import com.platzi.market.domain.PurchaseDTO;
import com.platzi.market.persistance.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<PurchaseDTO> getAll(){
        return purchaseRepository.getAll();
    }

    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        return purchaseRepository.save(purchaseDTO);
    }

    public Optional<List<PurchaseDTO>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }
}
