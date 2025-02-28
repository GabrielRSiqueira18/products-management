package domain.useCases;


import domain.factories.UserFactory;
import domain.repositories.ImMemoryUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.productsManagement.domain.management.application.repositories.UserRepository;
import project.productsManagement.domain.management.application.useCases.UserUseCase;
import project.productsManagement.domain.management.enterprise.entities.user.User;
import static org.junit.jupiter.api.Assertions.*;
import java.util.UUID;

public class UserUseCaseTest {
    UserRepository userRepository;
    UserUseCase userUseCase;

    @BeforeEach
    public void setUp() {
        userRepository = new ImMemoryUserRepository();
        userUseCase = new UserUseCase(userRepository);
    }

    @Test
    void itShouldBeCreateUser() {
        UUID id = UUID.randomUUID();

        User user = userUseCase.create(UserFactory.createUser(id, null, null, null));

        assertEquals(1, UserRepository.items.size());
        assertEquals(user, UserRepository.items.getFirst());
        assertEquals(user.getUsername(), UserRepository.items.getFirst().getUsername());
        assertEquals(user.getEmail(), UserRepository.items.getFirst().getEmail());
    }

    @Test
    void itShouldBeGetById() {
        UUID id = UUID.randomUUID();

        UserFactory.createUsers(4, id).forEach(userUseCase::create);
        User user = userUseCase.getById(id);

        assertEquals(user.getUsername(), "username4");
        assertEquals(user.getPassword(), "password4");
        assertEquals(user.getEmail(), "example4@hotmail.com");
        assertEquals(user.getID(), id);
    }
}
