package com.cibercafe.api_auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar los Clientes del Cibercafé.
 */
@RestController
@RequestMapping("/api/clientes")
public class ClientController {

    private List<Client> clientes = new ArrayList<>();
    private long currentId = 1;

    public ClientController() {
        clientes.add(new Client(currentId++, "Juan Perez", "10023456", "3001234567"));
    }

    @GetMapping
    public List<Client> listarClientes() {
        return clientes;
    }

    @PostMapping
    public ResponseEntity<Client> crearCliente(@RequestBody Client cliente) {
        cliente.setId(currentId++);
        clientes.add(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        boolean removido = clientes.removeIf(c -> c.getId().equals(id));
        if (removido) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
