package br.gabriel.product_management.domain.factories;

import br.gabriel.product_management.domain.management.enterprise.entities.scrappingProduct.ScrappingProduct;
import br.gabriel.product_management.domain.management.enterprise.entities.scrappingProduct.ScrappingProductProps;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScrappingProductFactory {
    public static List<ScrappingProduct> createScrappingProducts(int quantity, int target, Integer id) {
        List<ScrappingProduct> products = new ArrayList<>(quantity);
        for (int i = 1; i <= quantity; i++) {
            products.add(createScrappingProduct(i == target ? id : i * 10, i == target ? "product" + id : "product" + i * 100));
        }

        return products;
    }

    public static ScrappingProduct createScrappingProduct(Integer id, String productName) {
        return ScrappingProduct.create(
            id,
            new ScrappingProductProps(
                productName,
                "symbol",
                10.0,
                URI.create("http://www.teste.com.br"),
                URI.create("http://www.teste.com.br"),
                OffsetDateTime.now().minusDays(1),
                OffsetDateTime.now()
            )
        );
    }
}
