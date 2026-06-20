package com.cibercafe.api_auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar los Equipos del Cibercafé.
 * Provee operaciones CRUD: Crear, Leer, Actualizar y Eliminar.
 */
@RestController
@RequestMapping("/api/equipos")
public class ComputerController {

    // Lista simulada que actúa como nuestra base de datos temporal
    private List<Computer> computadores = new ArrayList<>();
    private long currentId = 1;

    public ComputerController() {
        // Datos iniciales
        computadores.add(new Computer(currentId++, "PC-01", "Disponible", 1500.0));
        computadores.add(new Computer(currentId++, "PC-02", "Ocupado", 1500.0));
    }

    // GET: Obtener todos los equipos
    @GetMapping
    public List<Computer> listarEquipos() {
        return computadores;
    }

    // POST: Agregar un nuevo equipo
    @PostMapping
    public ResponseEntity<Computer> crearEquipo(@RequestBody Computer equipo) {
        equipo.setId(currentId++);
        computadores.add(equipo);
        return ResponseEntity.ok(equipo);
    }

    // PUT: Actualizar el estado de un equipo existente
    @PutMapping("/{id}")
    public ResponseEntity<Computer> actualizarEquipo(@PathVariable Long id, @RequestBody Computer equipoActualizado) {
        Optional<Computer> equipoOpt = computadores.stream().filter(c -> c.getId().equals(id)).findFirst();
        if (equipoOpt.isPresent()) {
            Computer equipo = equipoOpt.get();
            equipo.setNombre(equipoActualizado.getNombre());
            equipo.setEstado(equipoActualizado.getEstado());
            equipo.setTarifaPorHora(equipoActualizado.getTarifaPorHora());
            return ResponseEntity.ok(equipo);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE: Eliminar un equipo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Long id) {
        boolean removido = computadores.removeIf(c -> c.getId().equals(id));
        if (removido) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
