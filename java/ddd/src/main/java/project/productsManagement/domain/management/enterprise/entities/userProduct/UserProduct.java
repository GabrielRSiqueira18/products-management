package project.productsManagement.domain.management.enterprise.entities.userProduct;

import project.productsManagement.core.entities.Entity;

import java.util.UUID;

public class UserProduct extends Entity<Integer, UserProductProps> {
    private static Integer ID = 1;

    protected UserProduct(Integer id, UserProductProps props) {
        super(id, props);
    }

    public UUID getUserId() {
        return props.userId;
    }

    public static UserProduct create(Integer id, UserProductProps props) {
        if (id == null) return new UserProduct(ID++, props);

        return new UserProduct(id, props);
    }
}
