package project.productsManagement.domain.management.application.useCases;

import project.productsManagement.core.Utils;
import project.productsManagement.domain.management.application.repositories.ScrappingProductsRepository;
import project.productsManagement.domain.management.enterprise.entities.scrappingProduct.ScrappingProduct;

import java.util.List;

public class ScrappingProductUseCases {
    public final ScrappingProductsRepository scrappingProductsRepository;

    public ScrappingProductUseCases(ScrappingProductsRepository scrappingProductsRepository) {
        this.scrappingProductsRepository = scrappingProductsRepository;
    }

    private void validateData(ScrappingProduct data) {
        if (data == null || Utils.classHasNullAttribute(data)) {
            throw new NullPointerException("ScrappingProduct must not be null");
        }
    }

    public ScrappingProduct create(ScrappingProduct data) {
        validateData(data);

        return scrappingProductsRepository.create(data);
    }

    public ScrappingProduct update(ScrappingProduct data) {
        validateData(data);

        return scrappingProductsRepository.update(data);
    }

    public void delete(ScrappingProduct data) {
        validateData(data);
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
