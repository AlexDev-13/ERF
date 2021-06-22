package com.gov.erf.controller.claim;


import com.gov.erf.dto.http.claim.ClaimDto;
import com.gov.erf.dto.http.request.AddClaimRequestDto;
import com.gov.erf.endpoint.claim.ClaimEndpoint;
import com.gov.erf.models.claims.Claim;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ClaimDto create(
//            @RequestPart("request") @ApiParam("AddClaimRequestDto") AddClaimRequestDto addClaimRequestDto,
//            @RequestPart(value = "file", required = false) MultipartFile file
//    ) throws Exception {
//        return claimEndpoint.create(addClaimRequestDto, file);
//    }

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
