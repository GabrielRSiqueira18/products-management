package project.productsManagement.domain.management.application.repositories;

import project.productsManagement.domain.management.enterprise.entities.userProduct.UserProduct;

import java.util.List;
import java.util.UUID;

public interface UserProductRepository {
    UserProduct create(UserProduct userProduct);
    UserProduct update(UserProduct userProduct);
    List<UserProduct> getByUserId(UUID id);
    UserProduct getByUId(Integer id);
    List<UserProduct> getAll();
    void delete(UserProduct userProduct);
    void deleteById(Integer id);
}
