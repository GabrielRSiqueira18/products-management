package br.gabriel.product_management.domain.useCases;

import br.gabriel.product_management.domain.factories.ScrappingProductFactory;
import br.gabriel.product_management.domain.repositories.ImMemoryScrappingProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.gabriel.product_management.domain.management.application.repositories.ScrappingProductsRepository;
import br.gabriel.product_management.domain.management.application.useCases.ScrappingProductUseCases;
import br.gabriel.product_management.domain.management.enterprise.entities.scrappingProduct.ScrappingProduct;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScrappingProductUseCaseTest {
    ScrappingProductsRepository scrappingProductsRepository;
    ScrappingProductUseCases sut;

    @BeforeEach
    public void setUp() {
        scrappingProductsRepository = new ImMemoryScrappingProductRepository();
        sut = new ScrappingProductUseCases(scrappingProductsRepository);

        ScrappingProductsRepository.items.clear();
    }

    @Test
    public void itShouldBeCreateScrappingProduct() {
        ScrappingProduct scrappingProduct = sut.create(
            ScrappingProductFactory.createScrappingProduct(4, "name")
        );

        assertEquals(1, ScrappingProductsRepository.items.size());
        assertTrue(ScrappingProductsRepository.items.contains(scrappingProduct));
    }

    @Test
    public void itShouldBeGetScrappingProductByProductName() {
        int id = 2;
        ScrappingProductsRepository.items.addAll(ScrappingProductFactory.createScrappingProducts(10, id, id));

        ScrappingProduct target = sut.getByProductName("product" + id);
        assertNotNull(target);
        assertTrue(ScrappingProductsRepository.items.contains(target));
        assertEquals(id, target.getID());
    }

    @Test
    public void itShouldBeGetScrappingProductById() {
        int id = 2;
        ScrappingProductsRepository.items.addAll(ScrappingProductFactory.createScrappingProducts(10, id, id));

        ScrappingProduct target = sut.getById(id);
        assertNotNull(target);
        assertTrue(ScrappingProductsRepository.items.contains(target));
        assertEquals(id, target.getID());
    }

    @Test
    public void itShouldBeGetAllScrappingProduct() {
        int id = 2;
        int quantity = 10;
        ScrappingProductsRepository.items.addAll(ScrappingProductFactory.createScrappingProducts(quantity, id, id));

        List<ScrappingProduct> target = sut.getAll();
        assertEquals(quantity, target.size());
    }

    @Test
    public void itShouldDeleteScrappingProductById() {
        int id = 2;
        int quantity = 10;
        ScrappingProductsRepository.items.addAll(ScrappingProductFactory.createScrappingProducts(quantity, id, id));

        sut.deleteById(id);
        assertEquals(quantity - 1, ScrappingProductsRepository.items.size());
        assertFalse(ScrappingProductsRepository.items.contains(sut.getById(id)));
    }

    @Test
    public void itShouldDeleteScrappingProductByEntity() {
        int id = 2;
        int quantity = 10;
        ScrappingProductsRepository.items.addAll(ScrappingProductFactory.createScrappingProducts(quantity, id, id));

        var target = ScrappingProductsRepository.items
            .stream()
            .filter(scrappingProduct -> scrappingProduct.getID() == id)
            .findFirst()
            .orElse(null);
        sut.delete(target);
        assertEquals(quantity - 1, ScrappingProductsRepository.items.size());
        assertFalse(ScrappingProductsRepository.items.contains(target));
    }
}
