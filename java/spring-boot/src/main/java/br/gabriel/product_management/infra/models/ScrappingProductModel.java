package br.gabriel.product_management.infra.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.net.URI;
import java.time.OffsetDateTime;

@Entity
@Table(name = "products_scrapping")
public class ScrappingProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 100, updatable = false)
    String name;

    @Column(nullable = false, length = 2, updatable = false)
    String priceSymbol;

    @Column(nullable = false, length = 1000, updatable = false, precision = 2)
    Double price;

    @Column(unique = true, nullable = false, length = 250, updatable = false)
    URI imageUrl;

    @Column(unique = true, nullable = false, length = 250, updatable = false)
    URI siteUrl;

    @Column(nullable = false, length = 30, updatable = false)
    OffsetDateTime crappingTime;

    @CreationTimestamp
    @Column(nullable = false, length = 30, updatable = false)
    OffsetDateTime createdAt;

}
