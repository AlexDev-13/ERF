package com.gov.erf.controller.claim;


import com.gov.erf.dto.http.claims.action.responsibleOrgan.ResponsibleOrganDto;
import com.gov.erf.dto.http.claims.action.responsibleOrgan.request.AddResponsibleOrganRequestDto;
import com.gov.erf.endpoint.claim.action.responsibleOrgan.ResponsibleOrganEndpoint;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/claim/action")
public class ClaimActionController {

    private final ResponsibleOrganEndpoint responsibleOrganEndpoint;

    public ClaimActionController
            (
                    ResponsibleOrganEndpoint responsibleOrganEndpoint
            ) {
        this.responsibleOrganEndpoint = responsibleOrganEndpoint;
    }

    @PostMapping("/{id}/accept-responsible-organ")
    public ResponsibleOrganDto acceptResponsibleOrgan(
            @PathVariable Long id,
            @RequestBody AddResponsibleOrganRequestDto addResponsibleOrganRequestDto
            ){
        return responsibleOrganEndpoint.perform(id, addResponsibleOrganRequestDto);
    }

}
