package domain.repositories;

import project.productsManagement.domain.management.application.repositories.ScrappingProductsRepository;
import project.productsManagement.domain.management.enterprise.entities.scrappingProduct.ScrappingProduct;

import java.util.ArrayList;
import java.util.List;

public class ImMemoryScrappingProductRepository implements ScrappingProductsRepository {
    private List<ScrappingProduct> scrappingProducts = new ArrayList<>(10);

    @Override
    public ScrappingProduct create(ScrappingProduct scrappingProduct) {
        scrappingProducts.add(scrappingProduct);

        return scrappingProduct;
    }

    @Override
    public ScrappingProduct update(ScrappingProduct scrappingProduct) {
        return null;
    }

    @Override
    public ScrappingProduct getById(Integer id) {
        return scrappingProducts.stream()
            .filter(e -> e.getID().equals(id))
            .findFirst()
            .orElse(null);
    }

    @Override
    public ScrappingProduct getByProductName(String productName) {
        return scrappingProducts.stream()
            .filter(e -> e.getProductName().equals(productName))
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<ScrappingProduct> getAll() {
        return scrappingProducts;
    }

    @Override
    public void delete(ScrappingProduct scrappingProduct) {
        scrappingProducts.remove(scrappingProduct);
    }

    @Override
    public void deleteById(Integer id) {
        scrappingProducts.removeIf(e -> e.getID().equals(id));
    }
}
