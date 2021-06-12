package com.gov.erf.controller.claim;


import com.gov.erf.dto.http.claims.ClaimDto;
import com.gov.erf.dto.http.claims.request.AddClaimRequestDto;
import com.gov.erf.endpoint.claim.ClaimEndpoint;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/claim")
public class ClaimController {

    private final ClaimEndpoint claimEndpoint;

    public ClaimController
            (
                    ClaimEndpoint claimEndpoint
            ) {
        this.claimEndpoint = claimEndpoint;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ClaimDto create(
            @RequestPart("request") @ApiParam("AddClaimRequestDto") AddClaimRequestDto addClaimRequestDto,
            @RequestPart(value = "file", required = false) MultipartFile file
    ) throws Exception {
        return claimEndpoint.create(addClaimRequestDto, file);
    }

    @PostMapping
    public ClaimDto create(
            @RequestBody AddClaimRequestDto addClaimRequestDto
    ) throws Exception {
        return claimEndpoint.create(addClaimRequestDto, null);
    }

    @GetMapping("/get/{id}")
    public ClaimDto getById(@PathVariable("id") Long id){
        return claimEndpoint.getById(id);
    }


    @GetMapping("/get-all")
    public Collection<ClaimDto> getAll(){
        return claimEndpoint.getAll();
    }

}
