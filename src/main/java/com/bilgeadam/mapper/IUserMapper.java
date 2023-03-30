package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.response.UserLoginResponseDto;
import com.bilgeadam.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User toUserRegisterDto(final UserRegisterRequestDto dto);

    UserLoginResponseDto toUserLoginDto(final User user);
}
