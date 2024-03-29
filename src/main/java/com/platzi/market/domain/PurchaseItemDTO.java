package com.platzi.market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseItemDTO {
    private int productId;
    private int quantity;
    private double total;
    private boolean active;
}
