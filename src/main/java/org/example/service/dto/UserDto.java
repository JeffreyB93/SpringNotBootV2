package org.example.service.dto;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserDto {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(name, userDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}