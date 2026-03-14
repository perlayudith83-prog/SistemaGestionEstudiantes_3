SISTEMA UNIFICADO DE GESTIÓN ACADÉMICA
Actividad Formativa 3 – Implementación de Herencia en Java

Autor: Perla Yudith Delgadillo Navarro
Lenguaje: Java

-----------------------------------------------------

DESCRIPCIÓN DEL PROYECTO

Este proyecto consiste en el desarrollo de un Sistema Unificado de Gestión Académica implementado en Java utilizando el paradigma de Programación Orientada a Objetos (POO).

El objetivo principal de esta actividad es aplicar el concepto de HERENCIA para extender una aplicación desarrollada previamente en la Unidad 2. Para ello se diseñaron diferentes clases que representan entidades del sistema educativo como alumnos, maestros, asignaturas, ciclos escolares y registros de calificaciones.

El sistema permite registrar alumnos, seleccionar materias según el tetramestre y calcular el promedio final del estudiante con base en distintos criterios de evaluación.

-----------------------------------------------------

OBJETIVO DE LA ACTIVIDAD

Aplicar el concepto de herencia en Java mediante la creación de clases derivadas que reutilicen atributos y métodos de una clase base, permitiendo mejorar la organización y reutilización del código dentro del sistema.

-----------------------------------------------------

FUNCIONALIDADES DEL SISTEMA

El sistema implementa las siguientes funcionalidades:

• Registro de información de un alumno
• Administración de asignaturas por tetramestre
• Registro de ciclos escolares
• Captura de calificaciones
• Validación de rangos de calificación (0 a 100)
• Cálculo del promedio por materia
• Cálculo del promedio general del alumno
• Control de carga académica para docentes (máximo 3 materias)

-----------------------------------------------------

ESTRUCTURA DEL PROYECTO

El sistema está compuesto por las siguientes clases:

Alumno
Representa a un estudiante y contiene información personal como nombre, edad, sexo, país y teléfonos.

Asignatura
Representa una materia dentro del sistema académico, incluyendo su nombre, periodo y créditos.

Maestro
Representa a un docente que puede impartir diferentes materias y tiene un límite de asignación.

CalificacionDetalle
Gestiona el registro de calificaciones del estudiante y calcula el promedio final utilizando ponderaciones.

CicloEscolar
Administra las materias disponibles y los alumnos inscritos en un periodo académico.

ExpedienteAcademico
Registra la relación entre alumno, materia y calificaciones obtenidas.

AdministradorSistema
Clase encargada de gestionar el sistema, incluyendo materias disponibles, ciclos escolares y registros académicos.

PlataformaEducativa
Clase principal que ejecuta el sistema y permite interactuar con el usuario mediante consola.

-----------------------------------------------------

LÓGICA DE CÁLCULO DE CALIFICACIONES

El promedio final de cada materia se calcula utilizando la siguiente ponderación:

Proyectos = 20%
Tareas = 20%
Actividades en clase = 10%
Examen Parcial 1 = 10%
Examen Parcial 2 = 10%
Examen Final = 30%

Promedio Final = 
(Proyectos * 0.20) +
(Tareas * 0.20) +
(Actividades * 0.10) +
(Examen1 * 0.10) +
(Examen2 * 0.10) +
(ExamenFinal * 0.30)

-----------------------------------------------------

REQUISITOS PARA EJECUTAR EL PROYECTO

• Java JDK 8 o superior
• Un IDE de desarrollo (IntelliJ IDEA, Eclipse o NetBeans)

-----------------------------------------------------

INSTRUCCIONES DE EJECUCIÓN

1. Clonar o descargar el repositorio desde GitHub.
2. Abrir el proyecto en el IDE de preferencia.
3. Compilar el archivo PlataformaEducativa.java.
4. Ejecutar la clase principal.
5. Seguir las instrucciones mostradas en la consola para registrar calificaciones.

-----------------------------------------------------

CONCEPTOS DE PROGRAMACIÓN UTILIZADOS

• Programación Orientada a Objetos
• Herencia
• Encapsulamiento
• Listas dinámicas (ArrayList)
• Validación de datos
• Manejo de excepciones
• Organización en clases y métodos

-----------------------------------------------------

REFERENCIAS

Deitel, P., & Deitel, H. (2017). Java: How to Program. Pearson.

Schildt, H. (2020). Java: The Complete Reference. McGraw-Hill Education.

Oracle Documentation. Java Programming Language.
https://docs.oracle.com/javase/

-----------------------------------------------------

FIN DEL DOCUMENTO
