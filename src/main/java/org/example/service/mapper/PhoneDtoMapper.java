package org.example.service.mapper;

import org.example.service.dto.PhoneDto;
import org.example.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhoneDtoMapper {
    PhoneDtoMapper INSTANCE = Mappers.getMapper(PhoneDtoMapper.class);

    @Mapping(source = "phoneNumber", target = "phoneNumber")
    PhoneDto toDto(Phone phone);

    @Mapping(source = "phoneNumber", target = "phoneNumber")
    Phone toEntity(PhoneDto phoneDto);

}
