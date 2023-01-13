package com.platzi.market.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productos")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer productId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "id_categoria")
    @OneToOne()
    private Integer categodyId;

    @Column(name = "codigo_barras")
    private String barCode;

    @Column(name = "precio_ventas")
    private Double price;

    @Column(name = "cantidad_stock")
    private Integer stock;

    @Column(name = "estado")
    private Boolean state;
}
