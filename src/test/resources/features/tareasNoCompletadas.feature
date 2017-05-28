# language: es
Característica: No se puede trabajar sobre tareas ya terminadas o tareas en proyectos terminados

  Antecedentes:
  	Dado hay una empresa y un proyecto
    Dado existe la iteración "Formulación"
  	Y el proyecto tiene el requisito "Burbujeo mayor al 2%"
  	Y Juan es un empleado
  	Y Federico es un empleado
  	Y existe una tarea llamada "Agregar burbujas" de la iteración "Formulación"
  	
  Escenario: Juan trabaja sobre una tarea completada
  	Dado la tarea "Agregar burbujas" está terminada
    Cuando Juan trabaja 1 horas sobre "Agregar burbujas"
    Entonces la operacion falla y devuelve el mensaje "No se puede registrar trabajo en una tarea terminada"
 	
  Escenario: Juan trabaja sobre una tarea de un proyecto que está terminado
  	Dado el proyecto está en estado terminado
  	Cuando Juan trabaja 1 horas sobre "Agregar burbujas"
  	Entonces la operacion falla y devuelve el mensaje "No se puede registrar trabajo en un proyecto que no esté en progreso" 

  Escenario: Juan trabaja sobre una tarea de un proyecto que está suspendido
  	Dado el proyecto está en estado suspendido
  	Cuando Juan trabaja 1 horas sobre "Agregar burbujas"
  	Entonces la operacion falla y devuelve el mensaje "No se puede registrar trabajo en un proyecto que no esté en progreso"

  Escenario: Juan trabaja sobre una tarea de un proyecto no iniciado
  	Dado el proyecto está en estado no iniciado
  	Cuando Juan trabaja 1 horas sobre "Agregar burbujas"
  	Entonces la operacion falla y devuelve el mensaje "No se puede registrar trabajo en un proyecto que no esté en progreso"