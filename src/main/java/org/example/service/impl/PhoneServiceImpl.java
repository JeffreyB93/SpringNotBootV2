package org.example.service.impl;

import org.example.model.Phone;
import org.example.repository.PhoneRepository;
import org.example.service.PhoneService;
import org.example.service.dto.PhoneDto;
import org.example.service.mapper.PhoneDtoMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public List<PhoneDto> findAll() {
        Iterable<Phone> phoneIterable = phoneRepository.findAll();
        List<Phone> phones = new ArrayList<>();
        for (Phone phone : phoneIterable) {
            phones.add(phone);
        }
        return phones.stream().map(PhoneDtoMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PhoneDto save(PhoneDto phoneDto) {
        Phone phone = PhoneDtoMapper.INSTANCE.toEntity(phoneDto);
        Phone phoneSave = phoneRepository.save(phone);
        return PhoneDtoMapper.INSTANCE.toDto(phoneSave);
    }

    @Override
    public PhoneDto findById(Long id) {
        Optional<Phone> phone = phoneRepository.findById(id);
        return PhoneDtoMapper.INSTANCE.toDto(phone.get());
    }

    @Override
    public boolean deleteById(Long id) {
        phoneRepository.deleteById(id);
        return true;
    }
}
