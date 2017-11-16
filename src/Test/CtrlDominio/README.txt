Sobre la clase CtrlDominio se han realizado pruebas usando drivers y stubs. No obstante, debido a que CtrlDominio trabaja
usando las clases Máquina y Partida, cuyo comportamiento varía a lo largo del tiempo (debido a la información que almacenan
y los cálculos que realizan) las pruebas con drivers y stubs no comprueban realmente el correcto funcionamiento de la clase
CtrlDominio (en realidad solo comprueban que no se produzca un fallo en la ejecución del código que termine la ejecución
del mismo, pero no el correcto funcionamiento de la clase). Por tanto, además de las pruebas con drivers y stubs se ha
hecho una prueba de integración, que puede encontrarse en el package llamado "Integridad_CtrlDominio".

El driver de CtrlDominio funciona mediante inputs y outputs por el canal estándar. Para ello, el driver consta de un menú que
muestra las opciones a probar, y cada opcion, de ser necesario, mostrará información sobre las operaciones adicionales a
realizar.

Dicho ésto, los tests realizados constan de las siguientes partes:
Sobre crear instancia CtrlDominio:
1_Crear la instancia de CtrlDominio

Sobre empezarPartida:
1_Prueba con dificultad FACIL y rol CODEMAKER

Sobre generarSolucion:
1_Introduccion de una solución válida

Sobre evaluarCandidato:
1_Introduccion de una evaluacion correcta

Sobre generarCandidato:
1_Introduccion de un candidato válido


Los inputs y outputs generados están en los ficheros input y output de este mismo package.