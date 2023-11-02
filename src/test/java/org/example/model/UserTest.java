package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private User user;
    private Long id = 1L;
    private String name = "WWW";
    private Phone phone = new Phone();
    private Role role = new Role();


    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId(1L);
        user.setName("WWW");
        phone.setPhoneNumber("111");
        user.setPhones(List.of(phone));
        role.setRoleName("Админ");
        user.setRoles(Set.of(role));
    }

    @Test
    void gettersAndSettersWorkCorrectly() {
        assertThat(user.getId()).isEqualTo(1L);
        assertThat(user.getName()).isEqualTo("WWW");
        assertThat(user.getPhones()).isEqualTo(List.of(phone));
        assertThat(user.getRoles()).isEqualTo(Set.of(role));
    }
}
