# Resumen del Trabajo Práctico Especial - Programación 3

## Descripción del Proyecto
El proyecto se centra en resolver problemas asociados a un contexto simplificado de procesadores y tareas. Se implementan distintos servicios de búsqueda y luego se aborda la asignación óptima de tareas a procesadores utilizando técnicas algorítmicas específicas.

## Estructura del Proyecto

### Primera Parte
- **Servicios de Búsqueda:**
  - **Servicio 1:** Obtener toda la información de una tarea dado su ID.
  - **Servicio 2:** Listar todas las tareas críticas o no críticas según elección del usuario.
  - **Servicio 3:** Obtener tareas en un rango específico de prioridad.
- **Implementación:** Clase `Servicios` que carga y procesa datos desde archivos CSV de procesadores y tareas, proporcionando métodos públicos para los servicios mencionados.

### Segunda Parte
- **Asignación de Tareas a Procesadores:**
  - **Objetivo:** Minimizar el tiempo final de ejecución considerando restricciones como límites de tareas críticas por procesador y tiempo máximo de ejecución para procesadores no refrigerados.
  - **Técnicas Algorítmicas:**
    - **Backtracking:** Exploración exhaustiva de todas las combinaciones posibles para encontrar la solución óptima.
    - **Greedy:** Asignación de tareas a procesadores basada en el máximo tiempo de ejecución disponible en cada paso.
      - **Estrategia Greedy:** Se elige en cada paso la tarea con el mayor tiempo de ejecución disponible que cumpla con las restricciones de asignación.
- **Resultados a Presentar:** Detalles de las soluciones obtenidas, tiempo máximo de ejecución, y métricas de costo (estados generados para Backtracking, candidatos considerados para Greedy).
- **Implementación:** Funciones específicas para cada técnica algorítmica, acompañadas de comentarios explicativos sobre la estrategia utilizada.

