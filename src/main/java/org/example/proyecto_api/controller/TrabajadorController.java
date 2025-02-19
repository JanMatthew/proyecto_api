package org.example.proyecto_api.controller;


import org.example.proyecto_api.model.Result;
import org.example.proyecto_api.model.Trabajador;
import org.example.proyecto_api.service.TrabajadorService;
import org.example.proyecto_api.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/trabajador")
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    Logger logger = Logger.getLogger(TrabajadorController.class.getName());

    @GetMapping
    private ResponseEntity<?> getAllTrabajadores(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(trabajadorService.getAllTrabajadores());
    }

    @PostMapping
    private ResponseEntity<?> addTrabajador(@RequestBody Trabajador trabajador,@AuthenticationPrincipal User user){
        return ResponseEntity.ok(trabajadorService.addTrabajador(trabajador));
    }

    @PutMapping
    private ResponseEntity<?> updateTrabajador(@RequestBody Trabajador trabajador,@AuthenticationPrincipal User user){
        return ResponseEntity.ok(trabajadorService.updateTrabajador(trabajador));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable Long id,@AuthenticationPrincipal User user) throws Throwable {
        try {
            return ResponseEntity.ok(new Result.Success<>(trabajadorService.deleteTrabajador(id)));
        }
        catch (Exception e) {
            return ResponseEntity.ok(new Result.Error(e.getMessage()) {
            });
        }
    }

}
