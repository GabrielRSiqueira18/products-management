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
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", unique = true, nullable = false, length = 250, updatable = false)
    String name;

    @Column(name = "site_name", nullable = false, length = 20, updatable = false)
    private String siteName;

    @Column(name = "price_symbol", nullable = false, length = 2, updatable = false)
    String priceSymbol;

    @Column(name = "price", nullable = false, updatable = false, precision = 2)
    Double price;

    @Column(name = "image_url", unique = true, nullable = false, length = 100, updatable = false)
    String imageUrl;

    @Column(name = "site_url", unique = true, nullable = false, length = 250, updatable = false)
    String siteUrl;

    @Column(name = "scrapping_time", nullable = false, length = 30, updatable = false)
    OffsetDateTime scrappingTime;

    @CreationTimestamp
    @Column(name = "created_at")
    OffsetDateTime createdAt;

    public ScrappingProductModel(
        String name,
        String siteName,
        String priceSymbol,
        Double price,
        String imageUrl,
        String siteUrl,
        OffsetDateTime scrappingTime
    ) {
        this.name = name;
        this.siteName = siteName;
        this.priceSymbol = priceSymbol;
        this.price = price;
        this.imageUrl = imageUrl;
        this.siteUrl = siteUrl;
        this.scrappingTime = scrappingTime;
    }

    public ScrappingProductModel() {}
}


