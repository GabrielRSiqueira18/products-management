package project.productsManagement.domain.management.application.repositories;

import project.productsManagement.domain.management.enterprise.entities.scrappingProduct.ScrappingProduct;

import java.util.List;
import java.util.UUID;

public interface ScrappingProductsRepository {
    ScrappingProduct create(ScrappingProduct scrappingProduct);
    ScrappingProduct update(ScrappingProduct scrappingProduct);
    ScrappingProduct getById(Integer id);
    ScrappingProduct getByProductName(String productName);
    List<ScrappingProduct> getAll();
    void delete(ScrappingProduct scrappingProduct);
    void deleteById(Integer id);
}
