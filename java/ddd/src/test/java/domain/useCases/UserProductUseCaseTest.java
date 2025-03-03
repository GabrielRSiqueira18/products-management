package domain.useCases;

import domain.factories.UserProductFactory;
import domain.repositories.InMemoryUserProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.productsManagement.domain.management.application.repositories.UserProductRepository;
import project.productsManagement.domain.management.application.repositories.UserRepository;
import project.productsManagement.domain.management.application.useCases.UserProductUseCase;
import project.productsManagement.domain.management.enterprise.entities.user.User;
import project.productsManagement.domain.management.enterprise.entities.user.UserProps;
import project.productsManagement.domain.management.enterprise.entities.userProduct.UserProduct;
import project.productsManagement.domain.management.enterprise.entities.userProduct.UserProductProps;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UserProductUseCaseTest {
    UserProductRepository userProductRepository;
    UserProductUseCase sut;
    public static UUID userId = UUID.randomUUID();

    @BeforeEach
    public void setUp() {
        userProductRepository = new InMemoryUserProductRepository();
        sut = new UserProductUseCase(userProductRepository);

        UserProductRepository.items.clear();
    }

    @BeforeAll
    public static void beforeAll() {
        UserRepository.items.clear();
        UserRepository.items.add(User.create(userId, new UserProps(
            "username",
            "example@hotmail.com",
            "password",
            OffsetDateTime.now()
        )));
    }

    @Test
    public void itShouldBeCreateUserProducts() {
        UserProduct userProduct = sut.create(
            UserProductFactory.createUserProduct(1, userId, "product")
        );

        assertEquals(1, UserProductRepository.items.size());
        assertTrue(UserProductRepository.items.contains(userProduct));
    }

    @Test
    public void itShouldBeGetUserProductsById() {
        int quantity = 10;
        Integer id = 3;

        UserProductFactory.createUserProducts(quantity, 3, id, userId, "product")
            .forEach(sut::create);

        UserProduct userProduct = sut.getById(id);

        assertEquals(quantity, UserProductRepository.items.size());
        assertTrue(UserProductRepository.items.contains(userProduct));
        assertEquals(id, userProduct.getID());
        assertEquals("product", userProduct.getProductName());
    }

    @Test
    public void itShouldBeGetUserProductsByUserId() {
        int quantity = 10;
        Integer id = 3;

        UserProductFactory.createUserProducts(quantity, 3, id, userId, "product")
                .forEach(sut::create);

        List<UserProduct> userProduct = sut.getByUserId(userId);

        assertEquals(quantity, userProduct.size());
    }

    @Test
    public void itShouldBeGetAllUserProducts() {
        int quantity = 10;
        Integer id = 3;

        UserProductFactory.createUserProducts(quantity, 3, id, userId, "product")
                .forEach(sut::create);

        List<UserProduct> userProduct = sut.getAll();

        assertEquals(quantity, userProduct.size());
    }

    @Test
    public void itShouldBeDeleteUserProductsById() {
        int quantity = 10;
        Integer id = 3;

        UserProductFactory.createUserProducts(quantity, 3, id, userId, "product")
                .forEach(sut::create);

        var toDelete = UserProductRepository.items
                .stream()
                .filter(userProduct -> userProduct.getID()
                .equals(id))
                .findFirst()
                .orElse(null);
        sut.deleteById(id);

        assertEquals(quantity - 1, UserProductRepository.items.size());
        assertFalse(UserProductRepository.items.contains(toDelete));
    }

    @Test
    public void itShouldBeDeleteUserProductsByEntity() {
        int quantity = 10;
        Integer id = 3;

        UserProductFactory.createUserProducts(quantity, 3, id, userId, "product")
                .forEach(sut::create);

        var toDelete = UserProductRepository.items
                .stream()
                .filter(userProduct -> userProduct.getID()
                        .equals(id))
                .findFirst()
                .orElse(null);
        sut.delete(toDelete);

        assertEquals(quantity - 1, UserProductRepository.items.size());
        assertFalse(UserProductRepository.items.contains(toDelete));
    }

    @Test
    public void itShouldBeUpdateUserProductsById() {
        int quantity = 10;
        Integer id = 3;

        UserProductFactory.createUserProducts(quantity, 3, id, userId, "product")
                .forEach(sut::create);

        String newProductName = "new-name";
        Double newPrice = 100.0;
         var toUpdate = sut.update(UserProduct.create(id, new UserProductProps(
                userId,
                newProductName,
                null,
                newPrice,
                null,
                null,
                null
        )));

        assertEquals(quantity, UserProductRepository.items.size());
        assertTrue(UserProductRepository.items.contains(toUpdate));
        assertEquals(newProductName, toUpdate.getProductName());
        assertEquals(newPrice, toUpdate.getPrice());
        assertFalse(toUpdate.propsHasNullValue());
    }
}
