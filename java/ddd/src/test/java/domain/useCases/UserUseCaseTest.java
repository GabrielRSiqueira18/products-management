package domain.useCases;


import domain.factories.UserFactory;
import domain.repositories.ImMemoryUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.productsManagement.domain.management.application.repositories.UserRepository;
import project.productsManagement.domain.management.application.useCases.UserUseCase;
import project.productsManagement.domain.management.enterprise.entities.user.User;
import project.productsManagement.domain.management.enterprise.entities.user.UserProps;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


public class UserUseCaseTest {
    UserRepository userRepository;
    UserUseCase sut;

    @BeforeEach
    public void setUp() {
        userRepository = new ImMemoryUserRepository();
        sut = new UserUseCase(userRepository);

        UserRepository.items.clear();
    }

    @Test
    void itShouldBeCreateUser() {
        UUID id = UUID.randomUUID();

        User user = sut.create(UserFactory.createUser(id, null, null, null));

        assertEquals(1, UserRepository.items.size());
        assertTrue(UserRepository.items.contains(user));
    }

    @Test
    void itShouldBeGetUserById() {
        UUID id = UUID.randomUUID();

        UserFactory.createUsers(10, 4, id).forEach(sut::create);
        User user = sut.getById(id);

        assertEquals("username4", user.getUsername());
        assertEquals("password4", user.getPassword());
        assertEquals("example4@hotmail.com", user.getEmail());
        assertEquals(user.getID(), id);
    }

    @Test
    void itShouldBeGetUserByUsername() {
        UUID id = UUID.randomUUID();

        UserFactory.createUsers(10, 4, id).forEach(sut::create);
        User user = sut.getByUsername("username4");

        assertEquals("username4", user.getUsername());
        assertEquals("password4", user.getPassword());
        assertEquals("example4@hotmail.com", user.getEmail());
        assertEquals(user.getID(), id);
    }

    @Test
    void itShouldBeGetUserByEmail() {
        UUID id = UUID.randomUUID();

        UserFactory.createUsers(10, 4, id).forEach(sut::create);
        User user = sut.getByEmail("example4@hotmail.com");

        assertEquals("username4", user.getUsername());
        assertEquals("password4", user.getPassword());
        assertEquals("example4@hotmail.com", user.getEmail());
        assertEquals(user.getID(), id);
    }

    @Test
    void itShouldBeGetAllUsers() {
        int userQuantity = 10;

        UserFactory.createUsers(userQuantity , 1, null).forEach(sut::create);
        List<User> users = sut.getAll();

        assertEquals(userQuantity, users.size());
    }

    @Test
    void itShouldBeDeleteUserById() {
        int userQuantity = 10;
        UUID id = UUID.randomUUID();

        UserFactory.createUsers(userQuantity , 6, id).forEach(sut::create);
        sut.deleteById(id);
        assertEquals(9, UserRepository.items.size());
    }

    @Test
    void itShouldBeDeleteUser() {
        int userQuantity = 10;
        UUID id = UUID.randomUUID();

        UserFactory.createUsers(userQuantity , 6, id).forEach(sut::create);
        User user = sut.getById(id);
        sut.delete(user);
        assertEquals(9, UserRepository.items.size());
    }

    @Test
    void itShouldBeUpdateUserById() {
        int quantity = 10;
        UUID id = UUID.randomUUID();

        UserFactory.createUsers(quantity , 6, id).forEach(sut::create);

        String newUsername = "new-username";
        String newEmail = "newEmail@hotmail.com";
        String newPassword = "new-password5";
        var toUpdate = sut.update(User.create(id, new UserProps(
                newUsername,
                newEmail,
                newPassword,
                null
        )));

        assertEquals(quantity, UserRepository.items.size());
        assertTrue(UserRepository.items.contains(toUpdate));
        assertEquals(newUsername, toUpdate.getUsername());
        assertEquals(newPassword, toUpdate.getPassword());
        assertEquals(newEmail, toUpdate.getEmail());
        assertFalse(toUpdate.propsHasNullValue());
    }
}
