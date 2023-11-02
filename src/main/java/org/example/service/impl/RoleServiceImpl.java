package org.example.service.impl;

import org.example.model.Role;
import org.example.repository.RoleRepository;
import org.example.service.RoleService;
import org.example.service.dto.RoleDto;
import org.example.service.mapper.RoleDtoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public RoleDto save(RoleDto roleDto) {
        Role role = RoleDtoMapper.INSTANCE.toEntity(roleDto);
        Role roleSave = roleRepository.save(role);
        return RoleDtoMapper.INSTANCE.toDto(roleSave);
    }

    @Override
    @Transactional
    public RoleDto findById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return RoleDtoMapper.INSTANCE.toDto(role.get());
    }

    @Override
    public boolean deleteById(Long id) {
        roleRepository.deleteById(id);
        return true;
    }

    @Override
    public List<RoleDto> findAll() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(RoleDtoMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
