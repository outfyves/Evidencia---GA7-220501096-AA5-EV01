package com.cibercafe.api_auth;

/**
 * Modelo que representa un Equipo (Computadora) dentro del Cibercafé.
 */
public class Computer {
    private Long id;
    private String nombre;
    private String estado; // Disponible, Ocupado, Mantenimiento
    private Double tarifaPorHora;

    public Computer() {}

    public Computer(Long id, String nombre, String estado, Double tarifaPorHora) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.tarifaPorHora = tarifaPorHora;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Double getTarifaPorHora() { return tarifaPorHora; }
    public void setTarifaPorHora(Double tarifaPorHora) { this.tarifaPorHora = tarifaPorHora; }
}
