package com.gov.erf.controller.claim;


import com.gov.erf.dto.http.tables.TableAuthorizedBodyDto;
import com.gov.erf.dto.http.tables.TableCommissionDto;
import com.gov.erf.dto.http.tables.TableResponsibleBodyDto;
import com.gov.erf.dto.http.tables.request.InfoRequestCommissionDto;
import com.gov.erf.dto.http.tables.request.InfoRequestFromAuthorizedBodyDto;
import com.gov.erf.dto.http.tables.request.InfoRequestFromResponsibleBodyDto;
import com.gov.erf.endpoint.claim.ClaimEndpoint;
import com.gov.erf.models.claims.tables.AuthorizedBody;
import com.gov.erf.models.claims.tables.ResponsibleBody;
import com.gov.erf.models.claims.tables.TableCommission;
import com.gov.erf.repository.claim.AuthorizedBodyRepository;
import com.gov.erf.repository.claim.ResponsibleBodyRepository;
import com.gov.erf.repository.claim.TableCommissionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("api/v1/claim/action")
public class ClaimActionController {

    private final ClaimEndpoint claimEndpoint;
    private final TableCommissionRepository tableCommissionRepository;
    private final ResponsibleBodyRepository responsibleBodyRepository;
    private final AuthorizedBodyRepository authorizedBodyRepository;

    public ClaimActionController
            (
                    ClaimEndpoint claimEndpoint,
                    TableCommissionRepository tableCommissionRepository, ResponsibleBodyRepository responsibleBodyRepository, AuthorizedBodyRepository authorizedBodyRepository) {
        this.claimEndpoint = claimEndpoint;
        this.tableCommissionRepository = tableCommissionRepository;

        this.responsibleBodyRepository = responsibleBodyRepository;
        this.authorizedBodyRepository = authorizedBodyRepository;
    }

    @PostMapping("/responsible-body")
    public TableResponsibleBodyDto perform(@RequestBody InfoRequestFromResponsibleBodyDto info) {
        return claimEndpoint.perform(info);
    }

    @PostMapping("/authorized-body")
    public TableAuthorizedBodyDto perform(@RequestBody InfoRequestFromAuthorizedBodyDto info) {
        return claimEndpoint.perform(info);
    }

    @PostMapping("/commission")
    public TableCommissionDto perform(@RequestBody InfoRequestCommissionDto info) {
        return claimEndpoint.perform(info);
    }


    @GetMapping("/responsible-body/get-all")
    public Collection<ResponsibleBody> getAll1() {
        return responsibleBodyRepository.findAll();
    }

    @GetMapping("/authorized-body/get-all")
    public Collection<AuthorizedBody> getAll2() {
        return authorizedBodyRepository.findAll();
    }

    @GetMapping("/commission/get-all")
    public Collection<TableCommission> getAll3() {
        return tableCommissionRepository.findAll();
    }

    @GetMapping("/responsible-body/get/{id}")
    public ResponsibleBody get1(@PathVariable("id") Long id) {
        return responsibleBodyRepository.findById(id).orElseThrow();
    }

    @GetMapping("/authorized-body/get/{id}")
    public AuthorizedBody get2(@PathVariable("id") Long id) {
        return authorizedBodyRepository.findById(id).orElseThrow();
    }

    @GetMapping("/commission/get/{id}")
    public TableCommission get3(@PathVariable("id") Long id) {
        return tableCommissionRepository.findById(id).orElseThrow();
    }




}
