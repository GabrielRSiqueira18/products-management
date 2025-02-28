package domain.repositories;

import project.productsManagement.domain.management.application.repositories.UserProductRepository;
import project.productsManagement.domain.management.enterprise.entities.userProduct.UserProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class InMemoryUserProductRepository implements UserProductRepository {
    private final List<UserProduct> usersProducts = new ArrayList<>(10);

    @Override
    public UserProduct create(UserProduct userProduct) {
        usersProducts.add(userProduct);

        return userProduct;
    }

    @Override
    public UserProduct update(UserProduct userProduct) {
        return null;
    }

    @Override
    public List<UserProduct> getByUserId(UUID id) {
        return usersProducts.stream()
            .filter(e -> e.getUserId().equals(id))
            .collect(Collectors.toList());
    }

    @Override
    public UserProduct getByUId(Integer id) {
        return usersProducts.stream()
            .filter(e -> e.getID().equals(id))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<UserProduct> getAll() {
        return usersProducts;
    }

    @Override
    public void delete(UserProduct userProduct) {
        usersProducts.remove(userProduct);
    }

    @Override
    public void deleteById(Integer id) {
        usersProducts.removeIf(e -> e.getID().equals(id));
    }
}
