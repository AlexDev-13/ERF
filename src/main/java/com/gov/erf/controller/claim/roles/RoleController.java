package com.gov.erf.controller.claim.roles;


import com.gov.erf.dto.http.account.RoleDto;
import com.gov.erf.dto.http.account.RoleRequestDto;
import com.gov.erf.endpoint.role.RoleEndpoint;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    private final RoleEndpoint roleEndpoint;

    public RoleController(RoleEndpoint roleEndpoint) {
        this.roleEndpoint = roleEndpoint;
    }


    @GetMapping("/{id}")
    public RoleDto getRoleById(@PathVariable("id") Long id){
        return roleEndpoint.getById(id);
    }

    @GetMapping("/all")
    public Collection<RoleDto> getAll(){
        return roleEndpoint.getAll();
    }

    @PostMapping
    public RoleDto create(RoleRequestDto roleRequestDto){
        return roleEndpoint.create(roleRequestDto);
    }


    @GetMapping("/delete/{id}")
    public RoleDto deleteRoleById(@PathVariable("id") Long id){
        return roleEndpoint.delete(id);
    }

}
