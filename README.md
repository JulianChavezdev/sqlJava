#  🏪 Gestión de Clientes — Actividad Entregable 1
 
Aplicación Java para la gestión de clientes de una pequeña tienda, implementada mediante el patrón **DAO (Data Access Object)**.
 
---
 
## 📋 Descripción
 
Una pequeña tienda necesita una aplicación para gestionar su base de clientes. El sistema permite realizar operaciones CRUD completas sobre los clientes, así como consultas avanzadas de filtrado, ordenación y estadísticas.
 
> ⚠️ **Restricción:** Solo se pueden utilizar las librerías vistas en clase.
 
---
 
## 🗂️ Estructura del Proyecto
 
```
src/
├── model/
│   └── Cliente.java          # POJO de la entidad Cliente
├── dao/
│   └── ClienteDAO.java       # Interfaz/clase con todas las operaciones de acceso a datos
└── main/
    └── Main.java             # Clase principal que ejecuta todas las operaciones
```
 
---
 
## 🧩 Entidades
 
### `Cliente`
 
Clase POJO que representa a un cliente de la tienda.
 
| Campo             | Tipo     | Descripción                        |
|-------------------|----------|------------------------------------|
| `id`              | `int`    | Identificador único del cliente    |
| `nombre`          | `String` | Nombre del cliente                 |
| `edad`            | `int`    | Edad del cliente                   |
| `dineroGastado`   | `double` | Total de dinero gastado en la tienda (€) |
| `productoComprados` | `int`  | Número total de productos comprados |
 
---
 
## ⚙️ Operaciones del DAO
 
El `ClienteDAO` implementa las siguientes operaciones:
 
### CRUD Básico
 
| # | Método | Descripción |
|---|--------|-------------|
| 1 | `insertar(Cliente c)` | Inserta un nuevo cliente |
| 2 | `actualizar(int id, ...)` | Actualiza cualquier campo de un cliente (excepto el ID) según su ID |
| 3 | `borrar(int id)` | Elimina un cliente según su ID |
| 4 | `obtenerPorId(int id)` | Devuelve un cliente según su ID |
| 5 | `obtenerTodos()` | Devuelve la lista completa de clientes |
 
### Consultas de Filtrado
 
| # | Método | Descripción |
|---|--------|-------------|
| 6  | `obtenerMayoresDe30()` | Clientes con edad > 30 años |
| 7  | `obtenerGastanMasDe500()` | Clientes que han gastado más de 500 € |
| 8  | `obtenerOrdenadosPorDineroGastado()` | Todos los clientes ordenados por dinero gastado (mayor → menor) |
| 9  | `obtenerTop3PorProductos()` | Los 3 clientes que más productos han comprado |
| 15 | `obtenerGastanMasDe200OrdenadosPorProductos()` | Clientes que han gastado más de 200 €, ordenados por productos comprados (menor → mayor) |
| 16 | `obtenerMasJovenGastaMasDe400()` | El cliente más joven que ha gastado más de 400 € |
 
### Consultas de Estadísticas / Agregados
 
| # | Método | Descripción |
|---|--------|-------------|
| 10 | `obtenerSumaTotalDineroGastado()` | Suma total del dinero gastado por todos los clientes |
| 11 | `obtenerMediaProductosComprados()` | Media de productos comprados por cliente |
| 12 | `obtenerMediaDineroMayores25ConMas3Productos()` | Media de dinero gastado por clientes > 25 años que han comprado más de 3 productos |
| 13 | `obtenerNumClientesGastanMasDe100()` | Número de clientes que han gastado más de 100 € |
| 14 | `obtenerNumClientesEdadEntre30y50()` | Número de clientes con edad entre 30 y 50 años |
 
---
 
## 🚀 Clase `Main`
 
La clase `Main` ejecuta **todas las operaciones** del DAO de forma secuencial.
 
### Consideraciones importantes
 
- Para las operaciones de **inserción, actualización y borrado**, se utiliza un mismo objeto `Cliente` para las tres operaciones consecutivas.
- El `Main` está diseñado para poder **ejecutarse múltiples veces** sin que los resultados de las consultas varíen entre ejecuciones (idempotencia en las consultas).
 
### Flujo de ejecución sugerido
 
```
1. Insertar cliente de prueba
2. Actualizar algún campo del cliente insertado
3. Borrar el cliente actualizado
──────────────────────────────
4. Obtener cliente por ID
5. Obtener todos los clientes
6. Obtener clientes mayores de 30
7. Obtener clientes que han gastado más de 500 €
8. Obtener clientes ordenados por dinero gastado
9. Obtener top 3 por productos comprados
10. Obtener suma total de dinero gastado
11. Obtener media de productos comprados
12. Obtener media de dinero (mayores de 25 con más de 3 productos)
13. Contar clientes que han gastado más de 100 €
14. Contar clientes con edad entre 30 y 50
15. Obtener clientes con > 200 € ordenados por productos
16. Obtener el cliente más joven con > 400 €
```
 
---
 
## 🛠️ Tecnologías
 
- **Lenguaje:** Java
- **Librerías:** únicamente las vistas en clase
- **Patrón de diseño:** DAO (Data Access Object)
 
---
 
## 📌 Notas adicionales
 
- El ID de un cliente **no puede ser modificado** mediante la operación de actualización.
- Los datos iniciales del sistema deben estar pre-cargados para que las consultas devuelvan resultados consistentes en cada ejecución del `Main`.
