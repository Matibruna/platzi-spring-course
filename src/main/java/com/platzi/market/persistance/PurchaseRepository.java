package com.platzi.market.persistance;

import com.platzi.market.domain.PurchaseDTO;
import com.platzi.market.persistance.crud.PurchaseCrudRepository;
import com.platzi.market.persistance.entity.Purchase;
import com.platzi.market.persistance.mapper.PurchaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements com.platzi.market.domain.repository.PurchaseRepository {

    private final PurchaseCrudRepository purchaseCrudRepository;

    PurchaseMapper mapper;

    public PurchaseRepository(PurchaseCrudRepository purchaseCrudRepository, PurchaseMapper mapper) {
        this.purchaseCrudRepository = purchaseCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<PurchaseDTO> getAll() {
        return mapper.toPurchasesDTO( (List<Purchase>) purchaseCrudRepository.findAll() );
    }

    @Override
    public Optional<List<PurchaseDTO>> getByClient(String clientId) {
        return purchaseCrudRepository.findByClientId(clientId).map(purchases -> mapper.toPurchasesDTO(purchases));
    }

    @Override
    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        Purchase purchase = mapper.toPurchase(purchaseDTO);

        purchase.getProductPurchases().forEach(purchaseItem -> purchaseItem.setPurchase(purchase));

        return mapper.toPurchaseDTO(purchaseCrudRepository.save(purchase));
    }
}
