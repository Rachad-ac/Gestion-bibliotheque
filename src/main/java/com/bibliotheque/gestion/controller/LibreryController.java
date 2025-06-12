package com.bibliotheque.gestion.controller;

import com.bibliotheque.gestion.model.LibreryDTO;
import com.bibliotheque.gestion.model.Response;
import com.bibliotheque.gestion.services.LibreryService;
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
@RequestMapping("librery")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LibreryController {

    private final LibreryService libreryService;

    @Operation(summary = "Create librery", description = "this endpoint takes input librery and saves it")
    @ApiResponses(value = {@ApiResponse(responseCode = "201",
            description = "Success"), @ApiResponse(responseCode = "400",
            description = "Request sent by the client was syntactically incorrect"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")})
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Response<Object> createLibrery(@RequestBody LibreryDTO libreryDTO) {
        try {
            var dto = libreryService.createLibrery(libreryDTO);
            return Response.ok().setPayload(dto).setMessage("Librery créé");
        } catch (Exception ex) {
            return Response.badRequest().setMessage(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<Object> updateLibrery(@Parameter(name = "id", description = "the librery id to updated")
                                              @PathVariable("id") Long id,
                                          @RequestBody LibreryDTO libreryDTO) {
        libreryDTO.setId(id);
        try {
            var dto = libreryService.updateLibrery(libreryDTO);
            return Response.ok().setPayload(dto).setMessage("librery modifié");
        } catch (Exception ex) {
            return Response.badRequest().setMessage(ex.getMessage());
        }

    }

    @Operation(summary = "Read the librery", description = "This endpoint is used to read librery, it takes input id librery")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Request sent by the client was syntactically incorrect"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")})
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<Object> getLibrery(@Parameter(name = "id", description = "the type librery id to valid") @PathVariable Long id) {
        try {
            var dto = libreryService.getLibrery(id);
            return Response.ok().setPayload(dto).setMessage("librery trouvé");
        } catch (Exception ex) {
            return Response.badRequest().setMessage(ex.getMessage());
        }
    }

    @Operation(summary = "Read all librery", description = "It takes input param of the page and returns this list related")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")})
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Response<Object> getAllLibrery(@RequestParam Map<String, String> searchParams, Pageable pageable) {
        var page = libreryService.getAllLibrery(searchParams, pageable);
        Response.PageMetadata metadata = Response.PageMetadata.builder()
                .number(page.getNumber()).totalElements(page.getTotalElements())
                .size(page.getSize()).totalPages(page.getTotalPages()).build();
        return Response.ok().setPayload(page.getContent()).setMetadata(metadata);
    }


    @Operation(summary = "delete the librery", description = "Delete librery, it takes input id librery")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "No content"),
            @ApiResponse(responseCode = "400", description = "Request sent by the client was syntactically incorrect"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error during request processing")})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLibrery(@PathVariable("id") Long id) {
        try {
            libreryService.deleteLibrery(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
