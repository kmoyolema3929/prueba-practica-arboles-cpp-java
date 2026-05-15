#  Sistema de Gestión de Estudiantes - Árbol Binario de Búsqueda (ABB)

##  Descripción del Proyecto

Este proyecto implementa un sistema académico para la **Universidad Técnica de Ambato** utilizando un **Árbol Binario de Búsqueda (ABB)** en Java.

El sistema permite gestionar estudiantes mediante operaciones eficientes de:

- Inserción
- Búsqueda
- Eliminación
- Recorridos del árbol
- Estadísticas académicas

Cada estudiante se organiza dentro del árbol según su número de cédula, permitiendo búsquedas rápidas y un manejo eficiente de la información.

---

# Datos almacenados por estudiante

Cada estudiante contiene la siguiente información:

- Cédula
- Apellidos
- Nombres
- Nota final
- Carrera
- Nivel

---

# 🗂️ Estructura del Proyecto

```text
prueba-practica-arboles-cpp-java/

src/
- Estudiante.java
- Nodo.java
- ArbolBinarioBusqueda.java
- Main.java

capturas/
- altura_arbol.png
- aprobados.png
- buscar_estudiante.png
- contar_estudiantes.png
- eliminar_estudiante.png
- insertar_estudiante.png
- mayor_nota.png
- menor_nota.png
- menu_principal.png
- niveles_BFS.png
- recorrido_inorden.png
- recorrido_postorden.png
- recorrido_preorden.png
- reprobados.png

README.md
```

---

#  Requisitos Previos

Antes de ejecutar el proyecto necesitas:

- Java JDK 8 o superior
- Visual Studio Code, IntelliJ IDEA o terminal
- Git (opcional)

---

#  Compilación y Ejecución

## Compilar el proyecto

```bash
javac src/*.java
```

## Ejecutar el programa

```bash
java -cp src Main
```

---

#  Menú Principal del Sistema

```text
=========================================
  SISTEMA DE GESTIÓN DE ESTUDIANTES
  Universidad Técnica de Ambato
=========================================

========== MENÚ PRINCIPAL ==========
1. Insertar estudiante
2. Buscar estudiante por cédula
3. Eliminar estudiante
4. Recorrido Inorden
5. Recorrido Preorden
6. Recorrido Postorden
7. Recorrido por niveles (BFS)
8. Contar estudiantes
9. Calcular altura del árbol
10. Mostrar estudiante con mayor nota
11. Mostrar estudiante con menor nota
12. Mostrar estudiantes aprobados
13. Mostrar estudiantes reprobados
14. Salir
=====================================
Seleccione una opción:
```

---

# ✅ Funcionalidades Implementadas

| Función | Descripción |
|---|---|
| insertarEstudiante() | Inserta un nuevo estudiante |
| buscarEstudiante() | Busca estudiantes por cédula |
| eliminarEstudiante() | Elimina un estudiante |
| recorridoInorden() | Recorrido Izq - Raíz - Der |
| recorridoPreorden() | Recorrido Raíz - Izq - Der |
| recorridoPostorden() | Recorrido Izq - Der - Raíz |
| recorridoPorNiveles() | Recorrido BFS usando Queue |
| contarNodos() | Cuenta estudiantes registrados |
| calcularAltura() | Calcula altura del árbol |
| buscarNotaMayor() | Estudiante con mayor nota |
| buscarNotaMenor() | Estudiante con menor nota |
| mostrarAprobados() | Nota mayor o igual a 7 |
| mostrarReprobados() | Nota menor a 7 |

---

#  Tipos de Recorridos del Árbol

##  Recorrido Inorden
**Izquierdo → Raíz → Derecho**

Muestra los estudiantes ordenados por cédula de menor a mayor.

### Utilidad:
Permite visualizar los datos ordenados.

---

##  Recorrido Preorden
**Raíz → Izquierdo → Derecho**

Primero visita la raíz y luego sus subárboles.

### Utilidad:
Útil para crear copias del árbol.

---

##  Recorrido Postorden
**Izquierdo → Derecho → Raíz**

Primero recorre hijos y al final la raíz.

### Utilidad:
Útil para eliminar estructuras del árbol.

---

## Recorrido BFS (Por Niveles)

Recorre el árbol nivel por nivel utilizando una cola (`Queue`).

### Utilidad:
Permite recorrer el árbol horizontalmente.

---

#  Ejemplo de Uso

## Insertar estudiante

```text
=== INSERTAR ESTUDIANTE ===

Ingrese cédula: 1723456789
Ingrese apellidos: Pérez Gómez
Ingrese nombres: Ana María
Ingrese nota final (0-10): 8.5
Ingrese carrera: Sistemas
Ingrese nivel: Tercero

Estudiante insertado correctamente.
```

---

## Buscar estudiante

```text
=== BUSCAR ESTUDIANTE ===

Ingrese cédula del estudiante: 1723456789

Estudiante encontrado:

Cédula: 1723456789
Nombre: Ana María Pérez Gómez
Nota: 8.50
Carrera: Sistemas
Nivel: Tercero
```

---

#  Tecnologías Utilizadas

- Lenguaje: Java
- Programación Orientada a Objetos (POO)
- Árbol Binario de Búsqueda (ABB)
- Recursividad
- Queue / BFS
- Scanner para entrada de datos

---

#  Conceptos Aplicados

Durante el desarrollo del proyecto se aplicaron conceptos fundamentales de:

- Estructuras de Datos
- Recursividad
- Árboles Binarios
- Algoritmos de búsqueda
- Recorridos de árboles
- Manejo de nodos
- Validación de datos
- Programación modular

---

#  Características del Código

✅ Código modular y organizado

✅ Separación de responsabilidades por clases

✅ Uso de recursividad en operaciones del árbol

✅ Validación de cédulas duplicadas

✅ Validación de rangos de notas

✅ Implementación de BFS con Queue

✅ Interfaz de consola amigable

✅ Comentarios explicativos en métodos importantes

---

#  Evidencias

Las capturas de ejecución se encuentran en la carpeta:

```text
capturas/
```

### Evidencias incluidas:

## Menú Principal
![Menú Principal](capturas/menu_principal.png)

## Insertar Estudiante
![Insertar Estudiante](capturas/insertar_estudiante.png)

## Buscar Estudiante
![Buscar Estudiante](capturas/buscar_estudiante.png)

## Eliminar Estudiante
![Eliminar Estudiante](capturas/eliminar_estudiante.png)

## Recorrido Inorden
![Recorrido Inorden](capturas/recorrido_inorden.png)

## Recorrido Preorden
![Recorrido Preorden](capturas/recorrido_preorden.png)

## Recorrido Postorden
![Recorrido Postorden](capturas/recorrido_postorden.png)

## Recorrido por Niveles (BFS)
![BFS](capturas/niveles_BFS.png)

## Contar Estudiantes
![Contar Estudiantes](capturas/contar_estudiantes.png)

## Altura del Árbol
![Altura del Árbol](capturas/altura_arbol.png)

## Mayor Nota
![Mayor Nota](capturas/mayor_nota.png)

## Menor Nota
![Menor Nota](capturas/menor_nota.png)

## Estudiantes Aprobados
![Aprobados](capturas/aprobados.png)

## Estudiantes Reprobados
![Reprobados](capturas/reprobados.png)

---

#  Repositorio GitHub

```text
https://github.com/kmoyolema3929/prueba-practica-arboles-cpp-java.git
```

---

# 👨‍💻 Autor

- Nombre: Katherine Moyolema
- Carrera: Ingeniería en Software
- Asignatura: Estructura de Datos
- Universidad: Universidad Técnica de Ambato
- Fecha: 14 de Mayo de 2026



