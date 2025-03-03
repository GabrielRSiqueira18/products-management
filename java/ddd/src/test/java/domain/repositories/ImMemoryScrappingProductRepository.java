package domain.repositories;

import project.productsManagement.domain.management.application.repositories.ScrappingProductsRepository;
import project.productsManagement.domain.management.enterprise.entities.scrappingProduct.ScrappingProduct;

import java.util.List;

public class ImMemoryScrappingProductRepository implements ScrappingProductsRepository {
    @Override
    public ScrappingProduct create(ScrappingProduct scrappingProduct) {
        items.add(scrappingProduct);

        return scrappingProduct;
    }

    @Override
    public ScrappingProduct getById(Integer id) {
        return items.stream()
            .filter(e -> e.getID().equals(id))
            .findFirst()
            .orElse(null);
    }

    @Override
    public ScrappingProduct getByProductName(String productName) {
        return items.stream()
            .filter(e -> e.getProductName().equals(productName))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<ScrappingProduct> getAll() {
        return items;
    }

    @Override
    public void delete(ScrappingProduct scrappingProduct) {
        items.remove(scrappingProduct);
    }

    @Override
    public void deleteById(Integer id) {
        items.removeIf(e -> e.getID().equals(id));
    }
}
