# Clase 5 — Funciones y datos: números complejos

Fundamentos de Programación Funcional y Concurrente
Escuela de Ingeniería de Sistemas y Computación, Universidad del Valle
Carlos Andrés Delgado Saavedra

Un tipo propio que se usa como si fuera del lenguaje: se construye, se suma
con `+`, se divide con `/` y se imprime legible. Eso es lo que quiere decir
abstraer datos.

## El tipo

Un número complejo tiene la forma `a + bi`, donde `a` y `b` son reales e `i`
cumple que `i` al cuadrado es -1. La clase guarda las dos partes:

```scala
class Complejos(val r: Double, val i: Double)
```

`r` es la parte real y `i` la imaginaria. Los objetos no cambian: cada
operación construye y devuelve uno nuevo, y deja intactos los operandos.

## Las operaciones

Con `q1 = a1 + b1·i` y `q2 = a2 + b2·i`:

| Operación | Parte real | Parte imaginaria |
|---|---|---|
| `q1 + q2` | a1 + a2 | b1 + b2 |
| `q1 - q2` | a1 - a2 | b1 - b2 |
| `q1 * q2` | a1·a2 - b1·b2 | a1·b2 + a2·b1 |
| `q1 / q2` | (a1·a2 + b1·b2) / (a2² + b2²) | (a2·b1 - a1·b2) / (a2² + b2²) |

En Scala los símbolos son nombres de método válidos, así que definir un
método llamado `+` es lo que permite escribir `q1 + q2` en lugar de
`q1.suma(q2)`.

## La representación en texto

`toString` devuelve el número en la forma `a + bi`, con un detalle: cuando la
parte imaginaria es negativa no se escribe `+ -3.0i` sino `- 3.0i`.

| Número | Se imprime |
|---|---|
| real 1.0, imaginaria 2.0 | `1.0 + 2.0i` |
| real -3.0, imaginaria -1.0 | `-3.0 - 1.0i` |

Los valores van redondeados a tres decimales:

```scala
Math.round(a * 1000.0) / 1000.0
```

## Lo que hay que resolver

Todo va en `app/src/main/scala/taller/Complejos.scala`: los cuatro operadores
y el `toString`. Estos son los casos que comprueban las pruebas, con
`q1 = 1.0 + 2.0i`, `q2 = 4.0 + 3.0i` y `q3 = 3.0 + 6.0i`:

| Expresión | Resultado |
|---|---|
| `q1.toString` | `1.0 + 2.0i` |
| `(q1 + q2).toString` | `5.0 + 5.0i` |
| `(q2 + q3).toString` | `7.0 + 9.0i` |
| `(q1 - q2).toString` | `-3.0 - 1.0i` |
| `(q2 - q3).toString` | `1.0 - 3.0i` |
| `(q1 * q2).toString` | `-2.0 + 11.0i` |
| `(q2 * q3).toString` | `-6.0 + 33.0i` |
| `(q1 / q2).toString` | `0.4 + 0.2i` |
| `(q2 / q3).toString` | `0.667 - 0.333i` |

El último caso es el que obliga al redondeo: sin él la división daría
`0.6666666666666666`.

## Cómo está organizado el proyecto

```
app/src/main/scala/taller/
    App.scala          programa de arranque
    Complejos.scala    aquí va el ejercicio

app/src/test/scala/taller/
    AppSuite.scala        comprueba que el entorno quedó bien
    ComplejosTest.scala   los casos de arriba
```

Su código va en `main`. Las pruebas viven aparte y no se tocan.

## Cómo se ejecuta

```bash
./gradlew test    # corre las pruebas
```

Las pruebas arrancan en rojo y el trabajo es ponerlas en verde. El informe
completo queda en `app/build/reports/tests/test/index.html`.

## Cómo se trabaja

1. Haga fork de este repositorio.
2. En su fork, abra la pestaña **Actions** y habilítelas. GitHub las deja
   desactivadas en las copias hasta que el dueño lo confirme.
3. Clone, resuelva, haga commit y suba a `main`.
4. Verifique en **Actions** que la última ejecución quedó en verde.

## Restricciones

Este curso trabaja sin estado mutable: nada de `var`, `while`, `return` ni
variables que cambien. El resultado correcto por el camino equivocado no
cuenta como resultado correcto.
