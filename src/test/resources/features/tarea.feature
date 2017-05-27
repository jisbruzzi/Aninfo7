# language: es
Característica: creación de tarea

  Escenario: Agregar tarea a backlog vacio
    Dado que mi backlog se encuentra vacio
    Cuando agrego una tarea
    Entonces la cantidad de tareas en el backlog es 1
