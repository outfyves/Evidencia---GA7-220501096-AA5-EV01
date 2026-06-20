# Evidencia GA7-220501096-AA5-EV01: Diseño y desarrollo de servicios web

Este repositorio contiene la evidencia solicitada por el SENA respecto al desarrollo de un servicio web (API REST) para la autenticación de usuarios. Se ha tomado el proyecto de **Cibercafé** como base lógica del ejercicio.

## 📌 Cumplimiento de los Requerimientos
1. **Desarrollo de servicio web (Login):** Se ha diseñado un endpoint `/api/auth/login` que recibe peticiones en formato JSON.
2. **Validación de Credenciales:** El sistema recibe usuario y contraseña. Si es correcto, devuelve *"Autenticación satisfactoria"*. En caso contrario, devuelve *"Error en la autenticación"*.
3. **Código comentado:** Todo el código fuente de los controladores y modelos contiene comentarios explicativos estilo Javadoc e *inline*.
4. **Herramientas de versionamiento:** Este proyecto cuenta con control de versiones con Git inicializado de forma local.

---

## 🚀 Tutorial de Pruebas

Para probar este servicio web puedes usar **Postman**, **Insomnia** o la extensión **Thunder Client** en VSCode.

### 1. Ejecutar el servicio (En VSCode o NetBeans)
Para ejecutar la API de Spring Boot, abre una terminal en la raíz del proyecto y corre:
```bash
./mvnw spring-boot:run
```
*(El servicio iniciará en `http://localhost:8080`)*

### 2. Probar Inicio de Sesión Exitoso
Realiza una petición **POST** a `http://localhost:8080/api/auth/login` con el siguiente cuerpo (Body) en formato JSON:

```json
{
    "usuario": "admin_cibercafe",
    "contrasena": "sena1234"
}
```
**Respuesta del servidor:**
```json
{
    "exito": true,
    "mensaje": "Autenticación satisfactoria. ¡Bienvenido al sistema del Cibercafé!"
}
```

### 3. Probar Inicio de Sesión Fallido
Cambia la contraseña en la misma petición y observa la respuesta:

```json
{
    "usuario": "admin_cibercafe",
    "contrasena": "clavamala"
}
```
**Respuesta del servidor:**
```json
{
    "exito": false,
    "mensaje": "Error en la autenticación: Usuario o contraseña incorrectos."
}
```
