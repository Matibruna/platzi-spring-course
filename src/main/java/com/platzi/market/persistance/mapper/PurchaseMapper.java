package com.platzi.market.persistance.mapper;

import com.platzi.market.domain.PurchaseDTO;
import com.platzi.market.persistance.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "productPurchases", target = "items")
    })
    PurchaseDTO toPurchaseDTO(Purchase purchase);
    List<PurchaseDTO> toPurchasesDTO(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Purchase toPurchase(PurchaseDTO purchaseDTO);
}
