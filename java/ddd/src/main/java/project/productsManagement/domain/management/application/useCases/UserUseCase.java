package project.productsManagement.domain.management.application.useCases;

import project.productsManagement.core.Utils;
import project.productsManagement.domain.management.application.repositories.UserRepository;
import project.productsManagement.domain.management.enterprise.entities.user.User;

import java.util.List;
import java.util.UUID;

public class UserUseCase {
    private final UserRepository userRepository;

    public UserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        Utils.hasNullValue(user);

        return userRepository.create(user);
    }

    public User update(User user) {
        return userRepository.update(user);
    }

    public User getById(UUID id) {
        return userRepository.getById(id);
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
