package com.bibliotheque.gestion.controller;

import com.bibliotheque.gestion.model.AuteurDTO;
import com.bibliotheque.gestion.model.Response;
import com.bibliotheque.gestion.services.AuteurService;
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
@RequestMapping("auteur")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuteurController {

    private final AuteurService auteurService;

    @Operation(summary = "Create auteur", description = "this endpoint takes input auteur and saves it")
    @ApiResponses(value = {@ApiResponse(responseCode = "201",
            description = "Success"), @ApiResponse(responseCode = "400",
            description = "Request sent by the client was syntactically incorrect"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")})
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Response<Object> createAuteur(@RequestBody AuteurDTO auteurDTO) {
        try {
            var dto = auteurService.createAuteur(auteurDTO);
            return Response.ok().setPayload(dto).setMessage("auteur créé");
        } catch (Exception ex) {
            return Response.badRequest().setMessage(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<Object> updateAuteur(@Parameter(name = "id", description = "the auteur id to updated")
                                         @PathVariable("id") Long id,
                                         @RequestBody AuteurDTO auteurDTO) {
        auteurDTO.setId(id);
        try {
            var dto = auteurService.updateAuteur(auteurDTO);
            return Response.ok().setPayload(dto).setMessage("auteur modifié");
        } catch (Exception ex) {
            return Response.badRequest().setMessage(ex.getMessage());
        }

    }

    @Operation(summary = "Read the auteur", description = "This endpoint is used to read auteur, it takes input id auteur")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Request sent by the client was syntactically incorrect"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")})
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<Object> getAuteur(@Parameter(name = "id", description = "the type auteur id to valid") @PathVariable Long id) {
        try {
            var dto = auteurService.getAuteur(id);
            return Response.ok().setPayload(dto).setMessage("auteur trouvé");
        } catch (Exception ex) {
            return Response.badRequest().setMessage(ex.getMessage());
        }
    }

    @Operation(summary = "Read all auteur", description = "It takes input param of the page and returns this list related")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")})
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Response<Object> getAllAuteur(@RequestParam Map<String, String> searchParams, Pageable pageable) {
        var page = auteurService.getAllAuteur(searchParams, pageable);
        Response.PageMetadata metadata = Response.PageMetadata.builder()
                .number(page.getNumber()).totalElements(page.getTotalElements())
                .size(page.getSize()).totalPages(page.getTotalPages()).build();
        return Response.ok().setPayload(page.getContent()).setMetadata(metadata);
    }

    @Operation(summary = "delete the auteur", description = "Delete auteur, it takes input id auteur")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "No content"),
            @ApiResponse(responseCode = "400", description = "Request sent by the client was syntactically incorrect"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuteur(@PathVariable("id") Long id) {
        try {
            auteurService.deleteAuteur(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
