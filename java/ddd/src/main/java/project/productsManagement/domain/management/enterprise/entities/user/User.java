package project.productsManagement.domain.management.enterprise.entities.user;

import project.productsManagement.core.entities.Entity;

import java.time.OffsetDateTime;
import java.util.UUID;

public class User extends Entity<UUID, UserProps> {
    protected User(UUID id, UserProps props) {
        super(id, props);
    }

    public static User create(UUID id, UserProps props) {
        return new User(id, props);
    }

    public String getUsername() {
        return props.username;
    }

    public String getEmail() {
        return props.email;
    }
}
