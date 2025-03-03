package project.productsManagement.domain.management.enterprise.entities.userProduct;

import project.productsManagement.core.props.ProductProps;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.UUID;

public class UserProductProps extends ProductProps {
    public UUID userId;

    public UserProductProps(
        UUID userId,
        String name,
        String priceSymbol,
        Double price,
        URI imageUrl,
        URI siteUrl,
        OffsetDateTime createdAt
    ) {
        super(
            name,
            priceSymbol,
            price,
            imageUrl,
            siteUrl,
            createdAt
        );

       this.userId = userId;
    }
}
