# language: es
Característica: creación de tarea
Antecedentes:
  	Dado hay una empresa y un proyecto

  Escenario: Agregar tarea a iteración vacía
    Dado existe la iteración "Formulación"
    Cuando existe una tarea llamada "Agregar burbujas" de la iteración "Formulación"
    Entonces la cantidad de tareas en de la iteración "Formulación" es 1
