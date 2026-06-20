package com.cibercafe.api_auth;

/**
 * Clase DTO (Data Transfer Object) para recibir la petición de inicio de sesión.
 * Contiene el usuario y la contraseña enviados desde el cliente.
 */
public class LoginRequest {
    
    private String usuario;
    private String contrasena;

    // Constructores vacíos requeridos por Spring Boot (Jackson) para deserializar el JSON
    public LoginRequest() {
    }

    public LoginRequest(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
