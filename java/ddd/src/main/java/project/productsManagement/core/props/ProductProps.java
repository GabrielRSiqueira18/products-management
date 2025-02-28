package project.productsManagement.core.props;

import java.net.URI;
import java.time.OffsetDateTime;

public class ProductProps {
    public String name;
    public String priceSymbol;
    public Double price;
    public URI imageUrl;
    public URI siteUrl;
    public OffsetDateTime crappingTime;
    public OffsetDateTime createdAt;

    public ProductProps(
        String name,
        String priceSymbol,
        Double price,
        URI imageUrl,
        URI siteUrl,
        OffsetDateTime crappingTime,
        OffsetDateTime createdAt
    ) {
        this.name = name;
        this.priceSymbol = priceSymbol;
        this.price = price;
        this.imageUrl = imageUrl;
        this.siteUrl = siteUrl;
        this.crappingTime = crappingTime;
        this.createdAt = createdAt;
    }
}
