package com.gov.erf.controller.claim;


import com.gov.erf.dto.http.tables.TableAuthorizedBodyDto;
import com.gov.erf.dto.http.tables.TableCommissionDto;
import com.gov.erf.dto.http.tables.TableResponsibleBodyDto;
import com.gov.erf.dto.http.tables.request.InfoRequestCommissionDto;
import com.gov.erf.dto.http.tables.request.InfoRequestFromAuthorizedBodyDto;
import com.gov.erf.dto.http.tables.request.InfoRequestFromResponsibleBodyDto;
import com.gov.erf.endpoint.claim.ClaimEndpoint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/claim/action")
public class ClaimActionController {

    private final ClaimEndpoint claimEndpoint;

    public ClaimActionController
            (
                    ClaimEndpoint claimEndpoint
            ) {
        this.claimEndpoint = claimEndpoint;
    }

    @PostMapping("/responsible-body")
    public TableResponsibleBodyDto perform(@RequestBody InfoRequestFromResponsibleBodyDto info){
        return claimEndpoint.perform(info);
    }

    @PostMapping("/authorized-body")
    public TableAuthorizedBodyDto perform(@RequestBody InfoRequestFromAuthorizedBodyDto info){
        return claimEndpoint.perform(info);
    }

    @PostMapping("/commission")
    public TableCommissionDto perform(@RequestBody InfoRequestCommissionDto info){
        return claimEndpoint.perform(info);
    }



}
