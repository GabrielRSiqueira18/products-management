package br.gabriel.product_management.domain.management.enterprise.entities.scrappingProduct;

import br.gabriel.product_management.core.props.ProductProps;

import java.net.URI;
import java.time.OffsetDateTime;

public class ScrappingProductProps extends ProductProps {
    public OffsetDateTime crappingTime;

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
            createdAt
        );

        this.crappingTime = crappingTime;
    }
}
