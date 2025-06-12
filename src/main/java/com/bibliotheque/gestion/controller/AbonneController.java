package com.bibliotheque.gestion.controller;

import com.bibliotheque.gestion.model.AbonneDTO;
import com.bibliotheque.gestion.model.Response;
import com.bibliotheque.gestion.services.AbonneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@RestController
@RequestMapping("abonne")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AbonneController {

    private final AbonneService abonneService;

    @Operation(summary = "Create abonne", description = "this endpoint takes input abonne and saves it")
    @ApiResponses(value = {@ApiResponse(responseCode = "201",
            description = "Success"), @ApiResponse(responseCode = "400",
            description = "Request sent by the client was syntactically incorrect"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")})
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Response<Object> createAbonne(@RequestBody AbonneDTO abonneDTO) {
        try {
            var dto = abonneService.createAbonne(abonneDTO);
            return Response.ok().setPayload(dto).setMessage("abonne créé");
        } catch (Exception ex) {
            return Response.badRequest().setMessage(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<Object> updateAbonne(@Parameter(name = "id", description = "the abonne id to updated")
                                          @PathVariable("id") Long id,
                                          @RequestBody AbonneDTO abonneDTO) {
        abonneDTO.setId(id);
        try {
            var dto = abonneService.updateAbonne(abonneDTO);
            return Response.ok().setPayload(dto).setMessage("abonne modifié");
        } catch (Exception ex) {
            return Response.badRequest().setMessage(ex.getMessage());
        }

    }

    @Operation(summary = "Read the abonne", description = "This endpoint is used to read abonne, it takes input id abonne")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Request sent by the client was syntactically incorrect"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")})
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<Object> getAbonne(@Parameter(name = "id", description = "the type abonne id to valid") @PathVariable Long id) {
        try {
            var dto = abonneService.getAbonne(id);
            return Response.ok().setPayload(dto).setMessage("abonne trouvé");
        } catch (Exception ex) {
            return Response.badRequest().setMessage(ex.getMessage());
        }
    }

    @Operation(summary = "Read all abonne", description = "It takes input param of the page and returns this list related")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")})
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Response<Object> getAllAbonne(@RequestParam Map<String, String> searchParams, Pageable pageable) {
        var page = abonneService.getAllAbonne(searchParams, pageable);
        Response.PageMetadata metadata = Response.PageMetadata.builder()
                .number(page.getNumber()).totalElements(page.getTotalElements())
                .size(page.getSize()).totalPages(page.getTotalPages()).build();
        return Response.ok().setPayload(page.getContent()).setMetadata(metadata);
    }


    @Operation(summary = "delete the abonne", description = "Delete abonne, it takes input id abonne")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "No content"),
            @ApiResponse(responseCode = "400", description = "Request sent by the client was syntactically incorrect"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAbonne(@PathVariable("id") Long id) {
        try {
            abonneService.deleteAbonne(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
