# language: es
Característica: creación de tarea
Antecedentes:
  	Dado hay una empresa y un proyecto

  Escenario: Agregar tarea a iteración vacía
    Dado existe la iteración vacía "Formulación"
    Cuando existe una tarea llamada "Agregar burbujas" de la iteración "Formulación"
    Entonces la cantidad de tareas en de la iteración "Formulación" es 1
   
  Escenario: Agregar más de una tarea a iteración vacía
    Dado existe la iteración vacía "Formulación"
    Cuando existe una tarea llamada "Agregar burbujas" de la iteración "Formulación"
    Cuando existe una tarea llamada "Agregar azucar" de la iteración "Formulación"
    Entonces la cantidad de tareas en de la iteración "Formulación" es 2
  
  Escenario: El mover tareas entre iteraciones es consistente (relación uno a muchos)
    Dado existe la iteración vacía "Formulación"
    Dado existe la iteración vacía "Pulido"
    Cuando existe una tarea llamada "Agregar burbujas" de la iteración "Formulación"
    Cuando existe una tarea llamada "Agregar azucar" de la iteración "Formulación"
    Cuando existe una tarea llamada "Agregar limón" de la iteración "Formulación"
    Cuando se mueve la tarea "Agregar limón" de "Formulación" a "Pulido"
    Entonces la cantidad de tareas en de la iteración "Formulación" es 2
    Y la cantidad de tareas en de la iteración "Pulido" es 1

