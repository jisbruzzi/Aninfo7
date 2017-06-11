# language: es
Característica: Medición del tiempo gastado en tareas, y no se puede trabajar sobre tareas ya terminadas o tareas en proyectos terminados

  Antecedentes:
  	Dado hay una empresa y un proyecto
    Dado existe la iteración "Formulación"
  	Y el proyecto tiene el requisito "Burbujeo mayor al 2%"
  	Y Juan es un empleado
  	Y Federico es un empleado
  	Y existe una tarea llamada "Agregar burbujas" de la iteración "Formulación"
  	
  Escenario: Juan trabaja sobre una tarea y el cambio se ve reflejado en el requerimiento
  	Dado a la tarea "Agregar burbujas" le corresponde el requisito "Burbujeo mayor al 2%"
  	Cuando Juan trabaja 2 horas sobre "Agregar burbujas"
  	Entonces el requerimiento "Burbujeo mayor al 2%" tiene 2 horas de trabajo

  Escenario: Juan y Federico trabajan sobre la misma tarea y eso se acumula
    Cuando Juan trabaja 2 horas sobre "Agregar burbujas"
    Y Federico trabaja 5 horas sobre "Agregar burbujas"
    Entonces la tarea "Agregar burbujas" tiene 7 horas de trabajo

  Escenario: Juan trabaja sobre dos tareas que tienen el mismo requisito, el tiempo se acumula al requisito
    Dado a la tarea "Agregar burbujas" le corresponde el requisito "Burbujeo mayor al 2%"
    Y existe una tarea llamada "Agregar ácido" de la iteración "Formulación"
    Y a la tarea "Agregar ácido" le corresponde el requisito "Burbujeo mayor al 2%"
    Cuando Juan trabaja 2 horas sobre "Agregar burbujas"
    Y Juan trabaja 3 horas sobre "Agregar ácido"
    Entonces el requerimiento "Burbujeo mayor al 2%" tiene 5 horas de trabajo
  	
  Escenario: Juan trabaja sobre una tarea completada
  	Dado la tarea "Agregar burbujas" está terminada
    Cuando Juan trabaja 1 horas sobre "Agregar burbujas"
    Entonces la operacion falla porque no se puede registrar trabajo en una tarea terminada
 	
  Escenario: Juan trabaja sobre una tarea de un proyecto que está terminado
  	Dado el proyecto está en estado terminado
  	Cuando Juan trabaja 1 horas sobre "Agregar burbujas"
  	Entonces la operacion falla porque no se puede registrar trabajo en un proyecto que no esté en progreso 

  Escenario: Juan trabaja sobre una tarea de un proyecto que está suspendido
  	Dado el proyecto está en estado suspendido
  	Cuando Juan trabaja 1 horas sobre "Agregar burbujas"
  	Entonces la operacion falla porque no se puede registrar trabajo en un proyecto que no esté en progreso

  Escenario: Juan trabaja sobre una tarea de un proyecto no iniciado
  	Dado el proyecto está en estado no iniciado
  	Cuando Juan trabaja 1 horas sobre "Agregar burbujas"
  	Entonces la operacion falla porque no se puede registrar trabajo en un proyecto que no esté en progreso