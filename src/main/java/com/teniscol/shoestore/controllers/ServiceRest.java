package com.teniscol.shoestore.controllers;

import com.teniscol.shoestore.model.Inventario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/restienda")
public class ServiceRest {

    private Inventario inventario = new Inventario();

    @Operation(
            tags = {"EndPoints"},
            summary = "Inventario",
            description = "Permite ver el Inventario de la tienda",
            responses = {
                @ApiResponse(
                    responseCode = "200",
                    description = "Se ejecuta correctamente el servicio",
                    content = {
                        @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Inventario.class))
                    })
    })

    @GetMapping("/inventario")
    public Map<String, Integer> obtenerInventario() {
        return inventario.getStock();
    }

    @Operation(
            tags = {"EndPoints"},
            summary = "Total",
            description = "Permite ver el total de tenis disponibles en la tienda",
            responses = {
                @ApiResponse(
                    responseCode = "200",
                    description = "Se ejecuta correctamente el servicio",
                        content = {
                                @Content(
                                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                                        schema = @Schema(implementation = Integer.class))
                        })
    })

    @GetMapping("/total")
    public int totalTenis() {
        return inventario.totalTenis();
    }

    @Operation(
            tags = {"EndPoints"},
            summary = "Comprar",
            description = "Permite comprar tenis del inventario de la tienda",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Se ha creado correctamente el servicio",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = String.class))
                            })
            })
    @PostMapping("/comprar")
    public ResponseEntity<String> comprar(
            @RequestParam int opcion,
            @RequestParam int talla,
            @RequestParam int cantidad) {

        String marca = inventario.obtenerMarca(opcion);

        if (marca == null) {
            return ResponseEntity.badRequest().body("Marca inválida");
        }

        if (talla < 35 || talla > 43) {
            return ResponseEntity.badRequest().body("Talla inválida");
        }

        if (!inventario.verificarStock(marca, cantidad)) {
            return ResponseEntity.badRequest()
                    .body("No hay suficiente stock de " + marca);
        }

        inventario.vender(marca, cantidad, talla);

        return new ResponseEntity<>("Compra realizada: " + cantidad + " " + marca, HttpStatus.CREATED);
    }

    @Operation(
            tags = {"EndPoints"},
            summary = "Actualizar",
            description = "Permite actualizar el stock de tenis de la tienda",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Se ejecuta correctamente el servicio",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = String.class))
                            })
            })
    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarStock(
            @RequestParam String marca,
            @RequestParam int cantidad) {

        inventario.getStock().put(marca, cantidad);

        return new ResponseEntity<>("Stock actualizado de " + marca, HttpStatus.OK);
    }

    @Operation(
            tags = {"EndPoints"},
            summary = "Eliminar",
            description = "Permite eliminar alguna marca de la tienda",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Se ejecuta correctamente el servicio",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = String.class))
                            })
            })
    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminarMarca(@RequestParam String marca) {

        inventario.getStock().remove(marca);

        return new ResponseEntity<>("Marca eliminada: " + marca, HttpStatus.OK);
    }

    //http://localhost:8006/proyecto/swagger-ui/index.html#/
}

