package br.gabriel.product_management.domain.management.enterprise.entities.userProduct;

import br.gabriel.product_management.core.entities.Entity;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.UUID;

public class UserProduct extends Entity<Integer, UserProductProps> {
    private static Integer ID = 1;

    protected UserProduct(Integer id, UserProductProps props) {
        super(id, props);
    }

    public UUID getUserId() {
        return props.userId;
    }

    public String getProductName() {
        return props.name;
    }

    public Double getPrice() {
        return props.price;
    }

    public String getPriceSymbol() {
        return props.priceSymbol;
    }

    public URI getImageUrl() {
        return props.imageUrl;
    }

    public URI getSiteUrl() {
        return props.siteUrl;
    }

    public OffsetDateTime getCreatedAt() {
        return props.createdAt;
    }

    public void setProductName(String productName) {
        props.name = productName;
    }

    public void setPriceSymbol(String priceSymbol) {
        props.priceSymbol = priceSymbol;
    }

    public void setPrice(Double price) {
        props.price = price;
    }

    public void setImageUrl(URI imageUrl) {
        props.imageUrl = imageUrl;
    }

    public void setSiteUrl(URI siteUrl) {
        props.siteUrl = siteUrl;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        props.createdAt = createdAt;
    }

    public static UserProduct create(Integer id, UserProductProps props) {
        if (id == null) return new UserProduct(ID++, props);

        return new UserProduct(id, props);
    }
}
