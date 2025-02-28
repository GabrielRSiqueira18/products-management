package project.productsManagement.domain.management.application.repositories;

import project.productsManagement.domain.management.enterprise.entities.user.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    User create(User user);
    User update(User user);
    User getById(UUID id);
    User getByEmail(String email);
    User getByUsername(String username);
    List<User> getAll();
    void delete(User user);
    void deleteById(UUID id);
}
