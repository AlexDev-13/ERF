package com.gov.erf.endpoint.account.impl;

import com.gov.erf.dto.http.account.AddUserRequestDto;
import com.gov.erf.dto.http.account.UserDto;
import com.gov.erf.endpoint.account.AccountEndpoint;
import com.gov.erf.mapper.account.AccountMapper;
import com.gov.erf.models.account.Admin;
import com.gov.erf.models.account.Role;
import com.gov.erf.service.account.RegisterService;
import com.gov.erf.service.account.role.RoleService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DefaultAccountEndpoint implements AccountEndpoint {

    private final RegisterService registerService;
    private final AccountMapper accountMapper;
    private final RoleService roleService;

    public DefaultAccountEndpoint
            (
                    RegisterService registerService,
                    AccountMapper accountMapper,
                    RoleService roleService) {
        this.registerService = registerService;
        this.accountMapper = accountMapper;
        this.roleService = roleService;
    }

    @Override
    public String register(AddUserRequestDto addUserRequestDto) {
        return registerService.register(addUserRequestDto);
    }

    @Override
    public String confirmToken(String token) {
        return registerService.confirmToken(token);
    }

    @Override
    public Collection<UserDto> getAllUsers() {

        Collection<Admin> admins = registerService.getAll();

        return accountMapper.toUserDtos(admins);
    }

    @Override
    public UserDto findById(Long id) {

        Admin admin = registerService.findById(id);
        return accountMapper.toUserDto(admin);
    }

    @Override
    public void deleteById(Long id) {
        registerService.deleteById(id);
    }

    @Override
    public UserDto updateUser(Long id, AddUserRequestDto requestDto) {

        Role role = roleService.findRole(requestDto.getRole().getTitle());

        Admin admin = registerService.findById(id);
        admin.setEmail(requestDto.getEmail());
        admin.setName(requestDto.getName());
        admin.setSurname(requestDto.getSurname());
        admin.setPatronymic(requestDto.getPatronymic());
        admin.setRole(role);
        admin.setPhone(requestDto.getPhoneNumber());

        return accountMapper.toUserDto(admin);
    }

}
