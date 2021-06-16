package com.gov.erf.mapper.account.impl;

import com.gov.erf.dto.http.account.RoleDto;
import com.gov.erf.dto.http.account.UserDto;
import com.gov.erf.mapper.account.AccountMapper;
import com.gov.erf.mapper.account.role.RoleMapper;
import com.gov.erf.models.account.Admin;
import com.gov.erf.models.account.Role;
import com.gov.erf.service.account.role.RoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class DefaultAccountMapper implements AccountMapper {

    private final RoleMapper roleMapper;
    private final RoleService roleService;

    public DefaultAccountMapper
            (
                    RoleMapper roleMapper,
                    RoleService roleService
            ) {
        this.roleMapper = roleMapper;
        this.roleService = roleService;
    }

    @Override
    public Collection<UserDto> toUserDtos(Collection<Admin> admins) {

        Collection<UserDto> userDtos = new ArrayList<>();

        for (Admin admin : admins) {
            userDtos.add(toUserDto(admin));
        }

        return userDtos;
    }


    @Override
    public UserDto toUserDto(Admin admin) {

        var userDto = new UserDto();

        Role role = roleService.findRole(admin.getRole().getTitle());
        RoleDto roleDto = roleMapper.toRoleDto(role);

        userDto.setId(admin.getId());
        userDto.setName(admin.getName());
        userDto.setSurname(admin.getSurname());
        userDto.setPatronymic(admin.getPatronymic());
        userDto.setUsername(admin.getUsername());
        userDto.setEmail(admin.getEmail());
        userDto.setRole(roleDto);
        return userDto;
    }
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
