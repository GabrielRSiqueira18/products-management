package br.gabriel.product_management.infra.controllers;

import br.gabriel.product_management.infra.models.ScrappingProductModel;
import br.gabriel.product_management.infra.services.ScrappingProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/web-scrapping")
public class ScrappingProductsController {
    private final ScrappingProductService scrappingProductService;

    @Autowired
    public ScrappingProductsController(ScrappingProductService scrappingProductService) {
        this.scrappingProductService = scrappingProductService;
    }

    @PostMapping("")
    @Operation(
        summary = "Obter produtos via web scraping",
        description = "Este endpoint realiza o web scraping de produtos e retorna os dados coletados.",
        requestBody = @RequestBody(description = "Dados do produto para scraping", required = true)
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produtos coletados com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro ao criar produto")
    })
    public ResponseEntity<Object> getScrappingProducts(@RequestBody ScrappingProductModel data) {
        return ResponseEntity.status(HttpStatus.OK).body(scrappingProductService.create(data));
    }
}
