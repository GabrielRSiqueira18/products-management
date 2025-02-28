package project.productsManagement.domain.management.application.useCases;

import project.productsManagement.core.Utils;
import project.productsManagement.domain.management.application.repositories.UserProductRepository;
import project.productsManagement.domain.management.enterprise.entities.scrappingProduct.ScrappingProduct;
import project.productsManagement.domain.management.enterprise.entities.userProduct.UserProduct;

import java.util.List;
import java.util.UUID;

public class UserProductUseCase {
    private final UserProductRepository userProductRepository;

    public UserProductUseCase(UserProductRepository userProductRepository) {
        this.userProductRepository = userProductRepository;
    }

    private void validateData(UserProduct data) {
        if (data == null || Utils.classHasNullAttribute(data)) {
            throw new NullPointerException("ScrappingProduct must not be null");
        }
    }

    public UserProduct create(UserProduct userProduct) {
        validateData(userProduct);

        return userProductRepository.create(userProduct);
    }

    public UserProduct update(UserProduct userProduct) {
        validateData(userProduct);

        return userProductRepository.update(userProduct);
    }

    public UserProduct getById(Integer id) {
        return userProductRepository.getByUId(id);
    }

    public List<UserProduct> getByUserId(UUID id) {
        return userProductRepository.getByUserId(id);
    }

    public List<UserProduct> getAll() {
        return userProductRepository.getAll();
    }

    public void delete(UserProduct userProduct) {
        userProductRepository.delete(userProduct);
    }

    public void deleteById(Integer id) {
        userProductRepository.deleteById(id);
    }
}
