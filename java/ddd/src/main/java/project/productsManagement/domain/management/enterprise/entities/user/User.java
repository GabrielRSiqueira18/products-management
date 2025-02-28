package project.productsManagement.domain.management.enterprise.entities.user;

import project.productsManagement.core.entities.Entity;

import java.time.OffsetDateTime;
import java.util.UUID;

public class User extends Entity<UUID, UserProps> {
    protected User(UUID id, UserProps props) {
        super(id, props);
    }

    public String getUsername() {
        return props.username;
    }

    public String getEmail() {
        return props.email;
    }

    public String getPassword() {
        return props.password;
    }

    public OffsetDateTime getCreatedAt() {
        return props.createdAt;
    }

    public void setPassword(String password) {
        props.password = password;
    }

    public void setUsername(String username) {
        props.username = username;
    }

    public void setEmail(String email) {
        props.email = email;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        props.createdAt = createdAt;
    }

    public static User create(UUID id, UserProps props) {
        return new User(id, props);
    }
}
