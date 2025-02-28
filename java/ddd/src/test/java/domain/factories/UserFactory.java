package domain.factories;

import project.productsManagement.domain.management.enterprise.entities.user.User;
import project.productsManagement.domain.management.enterprise.entities.user.UserProps;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserFactory {
    public static User createUser(UUID id, String username, String email, String password) {
        return User.create(
            id != null ? id : UUID.randomUUID(),
            new UserProps(
                username != null ? username : "username",
                email != null ? email : "example@hotmail.com",
                password != null ? password : "password",
                OffsetDateTime.now()
            )
        );
    }

    public static List<User> createUsers(int target, UUID id) {
        List<User> users = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            users.add(createUser(
                i == target ? id : UUID.randomUUID(),
                "username" + i,
                "example" + i + "@hotmail.com",
                "password" + i
            ));
        }

        return users;
    }
}
