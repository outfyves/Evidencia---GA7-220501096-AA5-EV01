# Documentación de Servicios Web (API) - Proyecto Cibercafé
**Evidencia:** GA7-220501096-AA5-EV03
**Tecnología:** Java Spring Boot

Esta documentación detalla los servicios web creados para interconectar el Frontend del sistema del Cibercafé (Módulos de Login, Equipos y Clientes) con la lógica de negocio.

---

## 1. Módulo de Autenticación
Servicio para validar el acceso al panel administrativo.
- **Ruta:** `/api/auth/login`
- **Método:** `POST`
- **Body Requerido (JSON):**
  ```json
  { "usuario": "admin", "contrasena": "1234" }
  ```
- **Respuesta (200 OK):** `{"exito": true, "mensaje": "Autenticación satisfactoria"}`

---

## 2. Módulo de Equipos (Computadores)
Servicios CRUD para gestionar los equipos de cómputo disponibles en el local.

### Listar Equipos
- **Ruta:** `/api/equipos`
- **Método:** `GET`
- **Descripción:** Retorna una lista con todos los equipos registrados y su estado actual.

### Registrar Equipo
- **Ruta:** `/api/equipos`
- **Método:** `POST`
- **Body Requerido (JSON):**
  ```json
  { "nombre": "PC-03", "estado": "Disponible", "tarifaPorHora": 1500.0 }
  ```

### Actualizar Equipo
- **Ruta:** `/api/equipos/{id}`
- **Método:** `PUT`
- **Descripción:** Permite modificar el estado de un equipo (ej. pasarlo de 'Disponible' a 'Mantenimiento').

### Eliminar Equipo
- **Ruta:** `/api/equipos/{id}`
- **Método:** `DELETE`

---

## 3. Módulo de Clientes
Servicios para administrar el registro de usuarios que frecuentan el Cibercafé.

### Listar Clientes
- **Ruta:** `/api/clientes`
- **Método:** `GET`
- **Descripción:** Devuelve el directorio de clientes registrados.

### Registrar Cliente
- **Ruta:** `/api/clientes`
- **Método:** `POST`
- **Body Requerido (JSON):**
  ```json
  { "nombre": "Maria Gomez", "documento": "12345678", "telefono": "3010000000" }
  ```

### Eliminar Cliente
- **Ruta:** `/api/clientes/{id}`
- **Método:** `DELETE`
