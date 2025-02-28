package project.productsManagement.domain.management.enterprise.entities.scrappingProduct;

import project.productsManagement.core.entities.Entity;

public class ScrappingProduct extends Entity<Integer, ScrappingProductProps> {
    private static Integer ID = 1;

    private ScrappingProduct(Integer id, ScrappingProductProps props) {
        super(id, props);
    }

    public static ScrappingProduct create(Integer id, ScrappingProductProps props) {
        if (id == null) return new ScrappingProduct(ID++, props);

        return new ScrappingProduct(id, props);
    }
}

