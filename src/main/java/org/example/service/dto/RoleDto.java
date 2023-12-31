package org.example.service.dto;


import java.util.Objects;

public class RoleDto {

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDto roleDto = (RoleDto) o;
        return Objects.equals(roleName, roleDto.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName);
    }
}