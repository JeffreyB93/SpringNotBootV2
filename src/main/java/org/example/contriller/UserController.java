package org.example.contriller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.service.UserService;
import org.example.service.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final ObjectMapper mapper;

    public UserController(UserService userService) {
        this.mapper = new ObjectMapper();
        this.userService = userService;
    }


    @GetMapping()
    public ResponseEntity<String> findAll() throws JsonProcessingException {
        List<UserDto> usersDto = userService.findAll();
        String jsonString = mapper.writeValueAsString(usersDto);
        return ResponseEntity.ok(jsonString);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) throws JsonProcessingException {
        UserDto user = userService.findById(id);
        String jsonString = mapper.writeValueAsString(user);
        return ResponseEntity.ok(jsonString);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody UserDto userDto) throws JsonProcessingException {
        UserDto userDtoSave = userService.save(userDto);
        String jsonString = mapper.writeValueAsString(userDtoSave);
        return ResponseEntity.ok(jsonString);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
