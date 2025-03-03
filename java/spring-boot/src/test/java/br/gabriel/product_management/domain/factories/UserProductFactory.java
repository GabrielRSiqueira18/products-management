package br.gabriel.product_management.domain.factories;

import br.gabriel.product_management.domain.management.enterprise.entities.userProduct.UserProduct;
import br.gabriel.product_management.domain.management.enterprise.entities.userProduct.UserProductProps;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserProductFactory {
    public static UserProduct createUserProduct(Integer id, UUID userId, String productName) {
        return UserProduct.create(id, new UserProductProps(
            userId,
            productName,
            "symbol",
            0.0,
            URI.create("http://www.teste.com.br"),
            URI.create("http://www.teste.com.br"),
            OffsetDateTime.now()
        ));
    }

    public static List<UserProduct> createUserProducts(int quantity, int target, Integer id, UUID userId, String productName) {
        List<UserProduct> userProducts = new ArrayList<>(quantity);

        for (int i = 0; i < quantity; i++) {
            userProducts.add(createUserProduct(target == i ? id : i * 100, userId, productName));
        }

        return userProducts;
    }
}
