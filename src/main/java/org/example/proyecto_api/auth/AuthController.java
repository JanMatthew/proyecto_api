package org.example.proyecto_api.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    Logger logger = Logger.getLogger(AuthController.class.getName());

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        logger.info("Solicitud de inicio de sesión para usuario: " + request.getUsername());
        try {
            AuthResponse response = authService.login(request);
            logger.info("Inicio de sesión exitoso para usuario: " + request.getUsername());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.info("Error en el inicio de sesión para usuario: " + request.getUsername() + " " +  e.getMessage());
            return ResponseEntity.status(401).body(new AuthResponse("Error en el inicio de sesión"));
        }
    }
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        logger.info("Solicitud de registro para usuario: " + request.getUsername());
        try{
            AuthResponse authResponse = authService.register(request);
            logger.info("Registro exitoso para usuario: " + request.getUsername());
            return ResponseEntity.ok(authResponse);
        }catch (Exception e){
            logger.info("Registro fallido para usuario: " + request.getUsername() + " " + e.getMessage());
            return ResponseEntity.status(400).body(new AuthResponse("Error en el registro"));
        }
    }
}
