package br.gabriel.product_management.domain.management.application.repositories;

import br.gabriel.product_management.domain.management.enterprise.entities.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface UserRepository {
    List<User> items = new ArrayList<>(10);

    User create(User user);
    User update(User user);
    User getById(UUID id);
    User getByEmail(String email);
    User getByUsername(String username);
    List<User> getAll();
    void delete(User user);
    void deleteById(UUID id);
}
