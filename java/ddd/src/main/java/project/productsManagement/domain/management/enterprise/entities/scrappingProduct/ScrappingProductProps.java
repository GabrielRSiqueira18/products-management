package project.productsManagement.domain.management.enterprise.entities.scrappingProduct;

import project.productsManagement.core.props.ProductProps;

import java.net.URI;
import java.time.OffsetDateTime;

public class ScrappingProductProps extends ProductProps {
    public ScrappingProductProps(
        String name,
        String priceSymbol,
        Double price,
        URI imageUrl,
        URI siteUrl,
        OffsetDateTime crappingTime,
        OffsetDateTime createdAt
    ) {
        super(
            name,
            priceSymbol,
            price,
            imageUrl,
            siteUrl,
            crappingTime,
            createdAt
        );
    }
}
