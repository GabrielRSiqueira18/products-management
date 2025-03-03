package br.gabriel.product_management.domain.management.application.useCases;

import br.gabriel.product_management.core.Utils;
import br.gabriel.product_management.domain.management.application.repositories.UserProductRepository;
import br.gabriel.product_management.domain.management.enterprise.entities.userProduct.UserProduct;

import java.util.List;
import java.util.UUID;

public class UserProductUseCase {
    private final UserProductRepository userProductRepository;

    public UserProductUseCase(UserProductRepository userProductRepository) {
        this.userProductRepository = userProductRepository;
    }

    public UserProduct create(UserProduct userProduct) {
        Utils.hasNullValue(userProduct);

        return userProductRepository.create(userProduct);
    }

    public UserProduct update(UserProduct userProduct) {
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
