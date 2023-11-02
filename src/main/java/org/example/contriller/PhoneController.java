package org.example.contriller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.example.service.PhoneService;
import org.example.service.dto.PhoneDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    private PhoneService phoneService;
    private ObjectMapper mapper;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
        this.mapper = new ObjectMapper();
    }

    @GetMapping()
    public ResponseEntity<String> findAll() throws JsonProcessingException {
        List<PhoneDto> phonesDto = phoneService.findAll();
        String jsonString = mapper.writeValueAsString(phonesDto);
        return ResponseEntity.ok(jsonString);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) throws JsonProcessingException {
        PhoneDto phoneDto = phoneService.findById(id);
        String jsonString = mapper.writeValueAsString(phoneDto);
        return ResponseEntity.ok(jsonString);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody PhoneDto phoneDto) throws JsonProcessingException {
        PhoneDto phoneDtoSave = phoneService.save(phoneDto);
        String jsonString = mapper.writeValueAsString(phoneDtoSave);
        return ResponseEntity.ok(jsonString);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        phoneService.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
