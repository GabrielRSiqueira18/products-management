package br.gabriel.product_management.core.props;

import java.net.URI;
import java.time.OffsetDateTime;

public class ProductProps {
    public String name;
    public String priceSymbol;
    public Double price;
    public URI imageUrl;
    public URI siteUrl;
    public OffsetDateTime createdAt;

    public ProductProps(
        String name,
        String priceSymbol,
        Double price,
        URI imageUrl,
        URI siteUrl,
        OffsetDateTime createdAt
    ) {
        this.name = name;
        this.priceSymbol = priceSymbol;
        this.price = price;
        this.imageUrl = imageUrl;
        this.siteUrl = siteUrl;
        this.createdAt = createdAt;
    }
}
