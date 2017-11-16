Sobre la clase Normas se ha realizado una prueba usando drivers y stubs. Para replicarlas, en este mismo package se
incluye el driver de Normas.

El driver de normas funciona mediante inputs y outputs por el canal estándar. Para ello, el driver consta de un menú que
muestra las opciones a probar, y cada opcion, de ser necesario, mostrará información sobre las operaciones adicionales a
realizar.

Dicho ésto, los tests realizados constan de las siguientes partes:

Para crear instancia Normas:
1_Se ha probado a crear la instancia de Normas.

Para calcularNB:
1_Prueba de un candidato y solución iguales
2_Prueba de un candidato y una solución con los mismos valores pero en posiciones diferentes
3_Prueba de un candidato y una solución con los mismos valores (algunos valores en las mismas posiciones y otros en
posiciones distintas)
4_Prueba de un candidado y una solución con algunos valores iguales (algunos valores en las mismas posiciones y otros en
posiciones distintas)
5_Prueba de un candidato y una solución con todos los valores distintos

Para el nivel de dificultad FACIL y comprobarLinea:
1_Prueba de un código válido.
2_Prueba de un código de longitud inválida.
3_Prueba de un código con más repeticiones de las permitidas.
4_Prueba de un código con valores fuera del rango válido.
5_Prueba de un código con carácteres no válidos (por ejemplo, 'a').

Para el nivel de dificultad MEDIO y comprobarLinea:
1_Prueba de un código válido.
2_Prueba de un código de longitud inválida.
3_Prueba de un código con valores fuera del rango válido.
4_Prueba de un código con carácteres no válidos (por ejemplo, 'a').

Para el nivel de dificultad DIFICIL y comprobarLinea:
1_Prueba de un código válido.
2_Prueba de un código de longitud inválida.
3_Prueba de un código con valores fuera del rango válido.
4_Prueba de un código con carácteres no válidos (por ejemplo, 'a').

Para comprobarNB:
1_Prueba de un candidato y una solución con un bn correcto
2_Prueba de un candidato y una solución con un bn incorrecto
3_Prueba con un bn de tamaño distinto a 2
4_Prueba con un bn con valores fuera del rango válido (menores que 0 o mayores que 4).

Los inputs y outputs generados están en los ficheros input y output de este mismo package.