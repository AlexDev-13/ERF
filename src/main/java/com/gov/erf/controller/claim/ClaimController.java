package com.gov.erf.controller.claim;


import com.gov.erf.dto.http.claim.ClaimDto;
import com.gov.erf.dto.http.request.AddClaimRequestDto;
import com.gov.erf.endpoint.claim.ClaimEndpoint;
import com.gov.erf.models.claims.Claim;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("api/v1/claim")
public class ClaimController {

    private final ClaimEndpoint claimEndpoint;

    public ClaimController
            (
                    ClaimEndpoint claimEndpoint
            ) {
        this.claimEndpoint = claimEndpoint;
    }

    @PostMapping(name = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ClaimDto create(
            @RequestPart("request") @ApiParam("AddClaimRequestDto") AddClaimRequestDto addClaimRequestDto,
            @RequestPart(value = "file", required = false) MultipartFile file
    ) throws Exception {
        return claimEndpoint.create(null,addClaimRequestDto, file);
    }

    @PostMapping("/{id}")
    public ClaimDto create(
            @PathVariable("id") Long id,
            @RequestBody AddClaimRequestDto addClaimRequestDto
    ) throws Exception {
        return claimEndpoint.create(id, addClaimRequestDto, null);
    }

    @PostMapping
    public ClaimDto create(
            @RequestBody AddClaimRequestDto addClaimRequestDto
    ) throws Exception {
        return claimEndpoint.create(null, addClaimRequestDto, null);
    }


    @GetMapping("/get/{id}")
    public ClaimDto getById(@PathVariable("id") Long id) {
        return claimEndpoint.getById(id);
    }


    @GetMapping("/get-all")
    public Page<Claim> getAll(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return claimEndpoint.getAll(pageable);
    }

}
