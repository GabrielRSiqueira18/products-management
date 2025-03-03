package br.gabriel.product_management.domain.repositories;

import br.gabriel.product_management.domain.management.application.repositories.UserRepository;
import br.gabriel.product_management.domain.management.enterprise.entities.user.User;

import java.util.List;
import java.util.UUID;

public class ImMemoryUserRepository implements UserRepository {
    @Override
    public User create(User user) {
        items.add(user);
        return user;
    }

    @Override
    public User update(User user) {
        var target = getById(user.getID());

        user.setUsername(user.getUsername() != null ? user.getUsername() : target.getUsername());
        user.setEmail(user.getEmail() != null ? user.getEmail() : target.getEmail());
        user.setPassword(user.getPassword() != null ? user.getPassword() : target.getPassword());
        user.setCreatedAt(target.getCreatedAt());

        items.set(items.indexOf(user), user);
        return user;
    }

    @Override
    public User getById(UUID id) {
       return items
               .stream()
               .filter(e -> e.getID().equals(id))
               .findFirst()
               .orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        return items.stream().filter(e -> e.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public User getByUsername(String username) {
        return items.stream().filter(e -> e.getUsername().equals(username)).findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return items;
    }

    @Override
    public void delete(User user) {
        items.remove(user);
    }

    @Override
    public void deleteById(UUID id) {
        items.removeIf(e -> e.getID().equals(id));
    }
}
