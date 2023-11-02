package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleTest {

    private Role role;
    private Long id = 1L;
    private String roleName = "Админ";

    private User user = new User();

    @BeforeEach
    public void setUp() {
        role = new Role();
        role.setId(1L);
        role.setRoleName(roleName);
        user.setName("QQQ");
        role.setUsers(Set.of(user));
    }

    @Test
    void gettersAndSettersWorkCorrectly() {
        assertThat(role.getId() ).isEqualTo(1L);
        assertThat(role.getRoleName()).isEqualTo(roleName);
        assertThat(role.getUsers()).isEqualTo(Set.of(user));
    }
}
