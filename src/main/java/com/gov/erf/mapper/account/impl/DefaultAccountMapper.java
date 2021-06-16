package com.gov.erf.mapper.account.impl;

import com.gov.erf.mapper.account.AccountMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultAccountMapper implements AccountMapper {

//
//    @Override
//    public UserDto toUserDto(User user) {
//
//        var userDto = new UserDto();
//
//        userDto.setName(user.getName());
//        userDto.setSurname(userDto.getSurname());
//        userDto.setPatronymic(userDto.getPatronymic());
//        userDto.setUsername(userDto.getUsername());
//        userDto.setEmail(userDto.getEmail());
//        return userDto;
//    }
//
//    @Override
//    public AddUserRequest toAddUserRequest(AddUserRequestDto addUserRequestDto) {
//        return AddUserRequest
//                .builder()
//                .name(addUserRequestDto.getName())
//                .surname(addUserRequestDto.getSurname())
//                .patronymic(addUserRequestDto.getPatronymic())
//                .username(addUserRequestDto.getUsername())
//                .email(addUserRequestDto.getEmail())
//                .password(addUserRequestDto.getPassword())
//                .build();
//    }
}
