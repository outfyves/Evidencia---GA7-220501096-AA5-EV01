package com.cibercafe.api_auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST que expone el servicio web de Autenticación.
 * Maneja las peticiones HTTP que llegan al endpoint /api/auth.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    // Credenciales mockeadas (simuladas) del administrador del Cibercafé para el ejercicio
    private static final String USUARIO_VALIDO = "admin_cibercafe";
    private static final String CONTRASENA_VALIDA = "sena1234";

    /**
     * Endpoint para iniciar sesión.
     * Recibe una solicitud POST en la ruta /api/auth/login.
     * 
     * @param request Datos del usuario enviados en formato JSON
     * @return ResponseEntity con un código de estado HTTP y un objeto LoginResponse en JSON
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        
        // Validación: Comprueba que los campos no vengan nulos o vacíos
        if (request.getUsuario() == null || request.getContrasena() == null) {
            LoginResponse respuesta = new LoginResponse(false, "Error: Debe proveer un usuario y contraseña.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
        }

        // Validación: Verifica si las credenciales coinciden con las registradas
        if (USUARIO_VALIDO.equals(request.getUsuario()) && CONTRASENA_VALIDA.equals(request.getContrasena())) {
            // Autenticación exitosa
            LoginResponse respuestaExitosa = new LoginResponse(true, "Autenticación satisfactoria. ¡Bienvenido al sistema del Cibercafé!");
            return ResponseEntity.ok(respuestaExitosa);
        } else {
            // Autenticación fallida (credenciales incorrectas)
            LoginResponse respuestaError = new LoginResponse(false, "Error en la autenticación: Usuario o contraseña incorrectos.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(respuestaError);
        }
    }
}
