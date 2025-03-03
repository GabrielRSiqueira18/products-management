package br.gabriel.product_management.infra.services;

import br.gabriel.product_management.infra.models.ScrappingProductModel;
import br.gabriel.product_management.infra.repositories.ScrappingProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScrappingProductService {
    private final ScrappingProductRepository productScrappingRepository;

    @Autowired
    public ScrappingProductService(ScrappingProductRepository productScrappingRepository) {
        this.productScrappingRepository = productScrappingRepository;
    }

    public ScrappingProductModel create(ScrappingProductModel data) {
        return productScrappingRepository.save(data);
    }
}
