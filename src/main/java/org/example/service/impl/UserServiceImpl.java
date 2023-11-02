package org.example.service.impl;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.example.service.dto.UserDto;
import org.example.service.mapper.UserDtoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto save(UserDto userDto) {
        User user = UserDtoMapper.INSTANCE.toEntity(userDto);
        User userSave = userRepository.save(user);
        return UserDtoMapper.INSTANCE.toDto(userSave);
    }

    @Override
    @Transactional
    public UserDto findById(Long id) {
        //Optional<User> user = userRepository.findByIdWithPones(id);
        //Optional<User> user = userRepository.findByIdWithPones(id);
        Optional<User> user = userRepository.findById(id);
        return UserDtoMapper.INSTANCE.toDto(user.get());
    }

    @Override
    public boolean deleteById(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        //List<User> users = userRepository.findAllWithRole();
        return users.stream().map(UserDtoMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
