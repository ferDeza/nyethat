# ⚔️ NyetHack: Mi Viaje de Aprendizaje con Kotlin

[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.3%2B-blue.svg )](https://kotlinlang.org/ )
[![Learning Path](https://img.shields.io/badge/Path-Big_Nerd_Ranch-red.svg )](https://www.bignerdranch.com/ )

Bienvenido a mi repositorio personal de **NyetHack**. Este proyecto no es solo un juego de rol basado en texto; es el testimonio de mi evolución como desarrollador de Kotlin, construido paso a paso siguiendo la guía de [*"Kotlin Programming: The Big Nerd Ranch Guide"*](https://www.bignerdranch.com/books/kotlin-programming-the-big-nerd-ranch-guide/ ).

---

## 🚀 Mi Proceso de Aprendizaje

Este repositorio documenta cómo pasé de entender la sintaxis básica a implementar arquitecturas complejas y patrones funcionales. Aquí detallo los hitos de mi camino:

### 📍 Fase 1: Fundamentos y Seguridad (Capítulos 1-8)
En esta etapa, senté las bases del proyecto. Aprendí a manejar la **seguridad contra nulos (Null Safety)**, una de las joyas de Kotlin, asegurando que mi código fuera robusto desde el inicio.
- **Logro**: Implementación del sistema de salud y aura del jugador con validaciones estrictas.
- **Concepto clave**: Operadores `?.`, `?:` y tipos anulables.

### 📍 Fase 2: Programación Funcional y Extensiones (Capítulos 9-12)
Aquí es donde Kotlin empezó a sentirse "mágico". Comencé a usar **lambdas** y **funciones de extensión** para limpiar el código y hacerlo más expresivo.
- **Logro**: Refactorización del sistema de mensajes de la taberna usando funciones de extensión sobre `String`.
- **Concepto clave**: Funciones de orden superior y receptores de funciones.

### 📍 Fase 3: Arquitectura y Objetos (Capítulos 13-16)
El juego cobró vida con la introducción de **clases abstractas**, **interfaces** y el patrón **Singleton** (`object`).
- **Logro**: Creación del sistema de combate dinámico. Definí la interfaz `Fightable` y la clase abstracta `Monster`, permitiendo que cualquier criatura (como el `Goblin`) pudiera interactuar con el jugador.
- **Concepto clave**: Herencia, polimorfismo y delegación de propiedades (`by lazy`).

### 📍 Fase 4: El Mundo de NyetHack (Capítulos 17-18+)
Finalmente, integré todo en un mundo navegable con coordenadas y un motor de juego persistente.
- **Logro**: Implementación del sistema de navegación bidimensional y el bucle principal de comandos.
- **Concepto clave**: Colecciones avanzadas, enums y manejo de estados complejos.

---

## 🛠️ Lo que he dominado

A través de este proyecto, he integrado las siguientes capacidades técnicas:

| Concepto | Aplicación en NyetHack |
| :--- | :--- |
| **Null Safety** | Evitar errores en tiempo de ejecución al interactuar con objetos del mundo. |
| **Extension Functions** | Añadir lógica de formateo a tipos estándar sin herencia. |
| **Functional Programming** | Procesar listas de monstruos y salas usando `map`, `filter` y `sum`. |
| **Object-Oriented Design** | Estructurar el juego mediante interfaces y clases abstractas. |
| **Singleton Pattern** | El motor `Game` como un objeto único que gestiona el estado global. |

---

## 📂 Estructura de mi Evolución

```text
src/com/bignerdranch/nyethack/
├── extensions/          # Mi exploración de la expresividad de Kotlin
├── Creature.kt          # Implementación de polimorfismo y combate
├── Game.kt              # El cerebro del proyecto (Singleton)
├── Navigation.kt        # Lógica de coordenadas y movimiento
├── Player.kt            # El modelo central del usuario
├── Room.kt              # Gestión de entornos y niveles de peligro
└── tavern.kt            # Lógica de interacción social y extensiones
