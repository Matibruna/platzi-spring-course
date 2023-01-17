package com.platzi.market.persistance.mapper;

import com.platzi.market.domain.PurchaseItemDTO;
import com.platzi.market.persistance.entity.PurchaseItem;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.productId", target = "productId"),
            @Mapping(source = "amount", target = "quantity"),
            @Mapping(source = "state", target = "active"),
    })
    PurchaseItemDTO toPurchaseItemDTO(PurchaseItem purchaseItem);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.purchaseId", ignore = true)
    })
    PurchaseItem toPurchaseItem(PurchaseItemDTO purchaseItemDTO);
}
