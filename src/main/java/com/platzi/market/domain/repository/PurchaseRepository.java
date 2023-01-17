package com.platzi.market.domain.repository;

import com.platzi.market.domain.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    public List<PurchaseDTO> getAll();

    public Optional<List<PurchaseDTO>> getByClient(String clientId);

    public PurchaseDTO save(PurchaseDTO purchaseDTO);
}
