package com.gov.erf.controller.claim;


import com.gov.erf.dto.http.account.UserDto;
import com.gov.erf.dto.http.claim.ClaimDto;
import com.gov.erf.dto.http.request.AddClaimRequestDto;
import com.gov.erf.endpoint.claim.ClaimEndpoint;
import com.gov.erf.mapper.account.AccountMapper;
import com.gov.erf.models.account.Admin;
import com.gov.erf.models.claims.Claim;
import com.gov.erf.repository.account.AdminRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("api/v1/claim")
public class ClaimController {

    private final ClaimEndpoint claimEndpoint;
    private final AccountMapper accountMapper;
    private final AdminRepository adminRepository;

    public ClaimController
            (
                    ClaimEndpoint claimEndpoint,
                    AccountMapper accountMapper, AdminRepository adminRepository) {
        this.claimEndpoint = claimEndpoint;
        this.accountMapper = accountMapper;
        this.adminRepository = adminRepository;
    }

//    @PostMapping(path = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ClaimDto create(
//            @RequestParam("request") AddClaimRequestDto addClaimRequestDto,
//            @RequestPart(value = "file", required = false) MultipartFile file
//    ) throws Exception {
//        return claimEndpoint.create(null, addClaimRequestDto, file);
//    }

    @PostMapping
    public ClaimDto create(
            @RequestBody AddClaimRequestDto addClaimRequestDto
//            @RequestPart(value = "file", required = false) MultipartFile file
    ) throws Exception {

        Long id;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getPrincipal().equals("anonymousUser")) {

            Admin admin = (Admin) auth.getPrincipal();
            UserDto userDto = accountMapper.toUserDto(admin);


            if (userDto != null) {
                id = userDto.getId();
            } else {
                id = null;
            }
            return claimEndpoint.create(id, addClaimRequestDto, null);

        } else {
            return claimEndpoint.create(null, addClaimRequestDto, null);

        }

    }
//
//    @PostMapping
//    public ClaimDto create(
//            @RequestBody AddClaimRequestDto addClaimRequestDto
//    ) throws Exception {
//        return claimEndpoint.create(null, addClaimRequestDto, null);
//    }


    @GetMapping("/get/{id}")
    public ClaimDto getById(@PathVariable("id") Long id) {
        return claimEndpoint.getById(id);
    }


    @GetMapping("/get-all")
    public Page<Claim> getAll(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return claimEndpoint.getAll(pageable);
    }

}
