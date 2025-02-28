package project.productsManagement;

import project.productsManagement.domain.management.enterprise.entities.product.Product;
import project.productsManagement.domain.management.enterprise.entities.product.ProductProps;
import project.productsManagement.domain.management.enterprise.entities.user.User;
import project.productsManagement.domain.management.enterprise.entities.user.UserProps;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.OffsetDateTime;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Product product = null;
        User user = null;
        UUID uuid = UUID.randomUUID();
        for (int i = 0; i < 10; i++) {
            product = Product.create(null, new ProductProps(
                "teste",
                "R$",
                10.0,
                URI.create("http://example.com/image.jpg"),
                URI.create("http://example.com/image.jpg"),
                OffsetDateTime.now(),
                OffsetDateTime.now()
            ));


        }

        user = User.create(uuid, new UserProps(
            "username",
            "email",
            "password",
            OffsetDateTime.now()
        ));

        System.out.println(user.getID());
        System.out.println(uuid);
        System.out.println(product.getID());
    }
}