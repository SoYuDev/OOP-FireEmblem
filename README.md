# OOP-FireEmblem

Proyecto FireEmblem, ejercicio de clase donde se ha implementado un sistema básico con personajes (estudiantes) y enemigos, donde se realiza un combate con base en atributos como **vida**, **ataque**, **defensa**, y **destreza**.

## Descripción del Proyecto

Este proyecto crea un juego de rol simple donde el jugador elige un personaje (Estudiante) y se enfrenta a enemigos con distintas destrezas. Los personajes y enemigos tienen atributos que afectan el resultado del combate. La experiencia y el nivel del jugador aumentan a medida que derrota enemigos, lo que mejora sus estadísticas.

## Clases Implementadas

### 1. **Clase Estudiante**

La clase `Estudiante` representa a los personajes que el jugador puede elegir. Tiene los siguientes atributos:

- **nombre**: Nombre del personaje (String).
- **casa**: Casa a la que pertenece (String).
- **nivel**: Nivel del personaje (int), por defecto 1.
- **vida**: Vida del personaje, un valor aleatorio entre 40 y 60.
- **ataque**: Ataque del personaje, un valor aleatorio entre 7 y 12.
- **defensa**: Defensa del personaje, un valor aleatorio entre 4 y 7.

### 2. **Clase Enemigo**

La clase `Enemigo` representa a los oponentes del juego. Tiene los siguientes atributos:

- **nombre**: Nombre del enemigo (String).
- **vida**: Vida del enemigo.
- **ataque**: Ataque del enemigo.
- **defensa**: Defensa del enemigo.
- **destreza**: Destreza del enemigo (enum), con los valores posibles:
  - **fuerte**
  - **débil**

Dependiendo de la destreza del enemigo, sus atributos serán ajustados de la siguiente manera:
- **Destreza fuerte**: 50 vida, 10 ataque, 4 defensa.
- **Destreza débil**: 30 vida, 8 ataque, 2 defensa.

### 3. **Clase Main**

La clase `Main` orquesta el juego y permite interactuar con el jugador. A continuación se describen las funcionalidades principales:

- **Bienvenida al usuario**: Inicia el juego dando la bienvenida al mundo de *Fire Emblem Three Houses*.
- **Selección de personaje**: El jugador puede elegir entre tres personajes, con sus nombres y casas.
- **Creación de Estudiante**: El jugador recibe un personaje con valores aleatorios para vida, ataque y defensa.
- **Selección de enemigos**: El jugador selecciona cuántos enemigos enfrentar (entre 2 y 5 enemigos).
- **Sistema de combate**: El personaje realiza tres ataques consecutivos y luego el enemigo contraataca. Las estadísticas del personaje y del enemigo se ajustan durante el combate.
- **Subida de nivel**: Al derrotar enemigos de destreza débil, el jugador sube un nivel, mejorando sus atributos (vida, ataque, defensa).
  - **Destreza débil**: Sube 1 nivel con mejoras moderadas.
  - **Destreza fuerte**: Sube 2 niveles con mejoras más grandes.
- **Resurrección del enemigo**: Después de cada batalla, el enemigo derrotado se "resucita" con su vida inicial y un aumento de 1 en ataque y defensa.
- **Condiciones de finalización**: El juego termina cuando el personaje muere o alcanza el nivel 10.

## Requisitos

Para ejecutar este proyecto, necesitas tener instalado:

- **JDK 11 o superior**.
- Un IDE como **Eclipse** o **IntelliJ IDEA** para compilar y ejecutar el código.

## Instrucciones para Ejecutar

1. **Clona el repositorio** a tu máquina local:

    ```bash
    git clone https://github.com/usuario/FireEmblem.git
    ```

2. **Importa el proyecto** en tu IDE preferido (Eclipse, IntelliJ, etc.).
3. **Ejecuta la clase `Main`** para comenzar el juego.
4. Sigue las instrucciones en pantalla para interactuar con el juego.

## Funcionalidades y Flujo del Juego

1. El usuario es bienvenido y se le muestra una lista de personajes para elegir.
2. Se crea un personaje con estadísticas aleatorias (vida, ataque y defensa).
3. El jugador selecciona el número de enemigos a enfrentar (2 a 5 enemigos).
4. El juego comienza y el personaje se enfrenta a los enemigos seleccionados.
5. El jugador ataca tres veces al enemigo, y el enemigo contraataca.
6. Se actualizan las estadísticas del personaje y enemigo, y se repite el ciclo.
7. Tras derrotar a un enemigo, el personaje sube de nivel según la destreza del enemigo derrotado.
8. El juego continúa hasta que el personaje muere o alcanza el nivel 10.

