package project.productsManagement.domain.management.application.repositories;

import project.productsManagement.domain.management.enterprise.entities.userProduct.UserProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface UserProductRepository {
    List<UserProduct> items = new ArrayList<>(10);

    UserProduct create(UserProduct userProduct);
    UserProduct update(UserProduct userProduct);
    List<UserProduct> getByUserId(UUID id);
    UserProduct getByUId(Integer id);
    List<UserProduct> getAll();
    void delete(UserProduct userProduct);
    void deleteById(Integer id);
}
