package br.gabriel.product_management.domain.management.application.useCases;

import br.gabriel.product_management.core.Utils;
import br.gabriel.product_management.domain.management.application.repositories.ScrappingProductsRepository;
import br.gabriel.product_management.domain.management.enterprise.entities.scrappingProduct.ScrappingProduct;

import java.util.List;

public class ScrappingProductUseCases {
    public final ScrappingProductsRepository scrappingProductsRepository;

    public ScrappingProductUseCases(ScrappingProductsRepository scrappingProductsRepository) {
        this.scrappingProductsRepository = scrappingProductsRepository;
    }

    public ScrappingProduct create(ScrappingProduct data) {
        Utils.hasNullValue(data);

        return scrappingProductsRepository.create(data);
    }

    public void delete(ScrappingProduct data) {
        Utils.hasNullValue(data);
        scrappingProductsRepository.delete(data);
    }

    public void deleteById(Integer id) {
        scrappingProductsRepository.deleteById(id);
    }

    public ScrappingProduct getById(Integer id) {
        return scrappingProductsRepository.getById(id);
    }

    public ScrappingProduct getByProductName(String productName) {
        return scrappingProductsRepository.getByProductName(productName);
    }

    public List<ScrappingProduct> getAll() {
        return scrappingProductsRepository.getAll();
    }

}
