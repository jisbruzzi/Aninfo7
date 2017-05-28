# language: es
Característica: Actualización automática de las estimaciones

  Antecedentes:
  	Dado hay una empresa y un proyecto
    Dado existe la iteración "Formulación"
  	Y el proyecto tiene el requisito "Burbujeo mayor al 2%"
  	Y Juan es un empleado
  	Y Federico es un empleado
  	Y existe una tarea llamada "Agregar burbujas" de la iteración "Formulación"

  Escenario: Cambia la estimación de las tareas
    Dado la tarea "Agregar burbujas" tiene una estimacion de 16 horas
    Cuando Federico trabaja 8 horas sobre "Agregar burbujas"
    Entonces la tarea "Agregar burbujas" se estima 50% completada

  Escenario: Puede trabajarse sobre la estimación
    Dado la tarea "Agregar burbujas" tiene una estimacion de 2 horas
    Cuando Federico trabaja 8 horas sobre "Agregar burbujas"
    Entonces la tarea "Agregar burbujas" se estima 400% completada
    