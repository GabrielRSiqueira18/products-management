package project.productsManagement.domain.management.enterprise.entities.product;

import project.productsManagement.core.entities.Entity;

public class Product extends Entity<Integer, ProductProps> {
    private static Integer ID = 1;

    private Product(Integer id, ProductProps props) {
        super(id, props);
    }

    public static Product create(Integer id, ProductProps props) {
        if (id == null) return new Product(ID++, props);

        return new Product(id, props);
    }
}

