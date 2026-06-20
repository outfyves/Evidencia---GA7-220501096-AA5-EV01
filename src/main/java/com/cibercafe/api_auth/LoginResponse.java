package com.cibercafe.api_auth;

/**
 * Clase DTO (Data Transfer Object) para estructurar la respuesta del servicio web.
 * Contendrá el mensaje de éxito o de error al intentar el inicio de sesión.
 */
public class LoginResponse {
    
    private boolean exito;
    private String mensaje;

    public LoginResponse(boolean exito, String mensaje) {
        this.exito = exito;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
