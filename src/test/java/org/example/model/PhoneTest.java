package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneTest {

    private Phone phone;
    private Long id = 1L;
    private String phoneNumber = "111";

    private User user = new User();

    @BeforeEach
    public void setUp() {
        phone = new Phone();
        phone.setId(1L);
        phone.setPhoneNumber(phoneNumber);
        user.setName("QQQ");
        phone.setUser(user);

        /*Phone phone1 = new Phone();
        phone1.setId(2L);
        phone1.setPhoneNumber("222");*/
    }

    @Test
    void gettersAndSettersWorkCorrectly() {
        assertThat(phone.getId() ).isEqualTo(1L);
        assertThat(phone.getPhoneNumber()).isEqualTo(phoneNumber);
        assertThat(phone.getUser()).isEqualTo(user);
    }
}
