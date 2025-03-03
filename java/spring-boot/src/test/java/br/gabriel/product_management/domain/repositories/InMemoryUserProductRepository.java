package br.gabriel.product_management.domain.repositories;

import br.gabriel.product_management.domain.management.application.repositories.UserProductRepository;
import br.gabriel.product_management.domain.management.enterprise.entities.userProduct.UserProduct;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class InMemoryUserProductRepository implements UserProductRepository {
    @Override
    public UserProduct create(UserProduct userProduct) {
        items.add(userProduct);

        return userProduct;
    }

    @Override
    public UserProduct update(UserProduct userProduct) {
        var target = getByUId(userProduct.getID());

        userProduct.setProductName(
                userProduct.getProductName() != null ?
                userProduct.getProductName() :
                target.getProductName());

        userProduct.setPrice(
                userProduct.getPrice() != null ?
                userProduct.getPrice() :
                target.getPrice());

        userProduct.setPriceSymbol(
                userProduct.getPriceSymbol() != null ?
                userProduct.getPriceSymbol() :
                target.getPriceSymbol());

        userProduct.setImageUrl(
                userProduct.getImageUrl() != null ?
                userProduct.getImageUrl() :
                target.getImageUrl());

        userProduct.setSiteUrl(
                userProduct.getSiteUrl() != null ?
                userProduct.getSiteUrl() :
                target.getSiteUrl());

        userProduct.setCreatedAt(target.getCreatedAt());

        items.set(items.indexOf(target), userProduct);
        return userProduct;
    }

    @Override
    public List<UserProduct> getByUserId(UUID id) {
        return items.stream()
            .filter(e -> e.getUserId().equals(id))
            .collect(Collectors.toList());
    }

    @Override
    public UserProduct getByUId(Integer id) {
        return items.stream()
            .filter(e -> e.getID().equals(id))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<UserProduct> getAll() {
        return items;
    }

    @Override
    public void delete(UserProduct userProduct) {
        items.remove(userProduct);
    }

    @Override
    public void deleteById(Integer id) {
        items.removeIf(e -> e.getID().equals(id));
    }
}
