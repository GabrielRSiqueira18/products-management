package br.gabriel.product_management.domain.management.application.repositories;

import br.gabriel.product_management.domain.management.enterprise.entities.scrappingProduct.ScrappingProduct;

import java.util.ArrayList;
import java.util.List;

public interface ScrappingProductsRepository {
    List<ScrappingProduct> items = new ArrayList<>(10);

    ScrappingProduct create(ScrappingProduct scrappingProduct);
    ScrappingProduct getById(Integer id);
    ScrappingProduct getByProductName(String productName);
    List<ScrappingProduct> getAll();
    void delete(ScrappingProduct scrappingProduct);
    void deleteById(Integer id);
}
