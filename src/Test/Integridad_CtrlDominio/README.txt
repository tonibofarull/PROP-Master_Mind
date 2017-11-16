Sobre la clase CtrlDominio se han realizado pruebas de integración, además de las correspondientes pruebas con drivers
y stubs. Las correspondientes pruebas con drivers y stubs pueden ser encontradas en el package "CtrlDominio".

El driver de CtrlDominio funciona mediante inputs y outputs por el canal estándar. Para ello, el driver consta de un menú que
muestra las opciones a probar, y cada opcion, de ser necesario, mostrará información sobre las operaciones adicionales a
realizar.

Dicho ésto, los tests realizados constan de las siguientes partes:
Sobre crear instancia CtrlDominio:
1_Crear la instancia de CtrlDominio

Sobre empezarPartida:
1_Prueba con dificultad FACIL y rol CODEMAKER
2_Prueba con dificultad FACIL y rol CODEBREAKER
3_Prueba con dificultad MEDIO y rol CODEMAKER
4_Prueba con dificultad MEDIO y rol CODEBREAKER
5_Prueba con dificultad DIFICIL y rol CODEMAKER
6_Prueba con dificultad DIFICIL y rol CODEBREAKER

Sobre generarSolucion:
1_Introduccion de una solución válida
2_Introducción de una solución de tamaño diferente al válido
3_Introducción de una solución con carácteres inválidos
4_Introducción de una solución con número de repeticiones fuera del rango permitido
5_Introducción de una solución con valores fuera del rango permitido
NOTA: Para esta prueba no probaremos todos los valores de solución posibles para cada dificultad, debido a que eso ya se
ha realizado anteriormente al testear la clase Normas. Simplemente queremos ver que muestra los mensajes de error
correspondientes

Sobre evaluarCandidato:
1_Introduccion de una evaluacion correcta
2_Introduccion de una evaluacion incorrecta
3_Introduccion de una evaluación con valores fuera del rango correcto
4_Introduccion de una evaluacion con mas o menos valores de los correctos

Sobre generarCandidato:
1_Introduccion de un candidato válido
2_Introducción de un candidato de tamaño diferente al válido
3_Introducción de un candidato con carácteres inválidos
4_Introducción de un candidato con número de repeticiones fuera del rango permitido
5_Introducción de un candidato con valores fuera del rango permitido
NOTA: Para esta prueba no probaremos todos los valores de candidato posibles para cada dificultad, debido a que eso ya se
ha realizado anteriormente al testear la clase Normas. Simplemente queremos ver que muestra los mensajes de error
correspondientes

Los inputs y outputs generados están en los ficheros input y output de este mismo package.