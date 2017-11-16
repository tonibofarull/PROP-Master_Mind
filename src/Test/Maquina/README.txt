Los tests constan de 3 partes,
la primer comprueba la constructura, la segunda generarCandidato y la tercera  el generador random de soluciones iniciales.

En la primera parte:

Probamos las distintas inicializaciones. No se devuelve ningun mensaje en caso de funcionar correctamente.

En la segunda parte:

Probamos que para las diferentes dificultades se generar los 4 primeros valores correctamente.
Se hacen 4 ejecuciones para cada dificultad.
Los valores obtenidos 1122 o 1234 debido a que cada test es aislado (se construye una nueva instancia de Maquina).

En la tercera parte:

Probamos todas las dificultades como anteriormente y generamos 4 valores random para la solucion.
Observacion: el test para generar la solucion inicial no se puede recrear debido a que los valores se generar de forma aleatoria.