package br.gabriel.product_management.domain.management.enterprise.entities.user;

import java.time.OffsetDateTime;

public class UserProps {
    public String username;
    public String email;
    public String password;
    public OffsetDateTime createdAt;

    public UserProps(String username, String email, String password, OffsetDateTime createdAt) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }
}
