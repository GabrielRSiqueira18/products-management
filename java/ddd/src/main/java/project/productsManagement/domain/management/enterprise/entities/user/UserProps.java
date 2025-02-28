package project.productsManagement.domain.management.enterprise.entities.user;

import java.time.OffsetDateTime;

public class UserProps {
    public String username;
    public String email;
    public String password;
    OffsetDateTime createdAt;

    public UserProps(String username, String email, String password, OffsetDateTime createdAt) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }
}
