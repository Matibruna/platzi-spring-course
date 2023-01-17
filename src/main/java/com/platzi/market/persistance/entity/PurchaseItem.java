package com.platzi.market.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "compras_productos")
@Getter
@Setter
public class PurchaseItem {

    @EmbeddedId
    private PurchaseItemPK id;

    @Column(name = "cantidad")
    private Integer amount;

    private BigDecimal total;

    @Column(name = "estado")
    private Boolean state;

    @ManyToOne
    @MapsId("purchaseId")
    @JoinColumn(name = "id_compra", updatable = false, insertable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", updatable = false, insertable = false)
    private Product product;
}
