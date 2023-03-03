12. Mensajería
Kafka
Nombre proyecto Maven: block12-kafka
Usando Kafka, montar dos aplicaciones: una que envíe mensajes y la segunda le responda con otros mensajes.


Tercera versión de este ejercicio.

Dos aplicaciones independientes, una aplicación corresponde a la pizzería y la otra al cliente.

La pizzería tiene un productor que envía al tópico pedido el estado actual del mismo.
El cliente consumer puede está suscrito a ese tópico que puede consultarlo para vers
las actualizaciones de su pedido.
A su vez el cliente cuenta con un producer para enviar comentario al topic comentario.
Y la pizzería también cuenta con un consumidor del topic comentario para leerlos.

Se deja abierta la posibilidad de realizar la solicitud updatePedido desde formulario
html, pero de momento aún no se controla de JavaScript con lo que el propio formulario
indica de realizar las solicitudes desde Postman.

Se adjunta el fichero Postman donde a través de Endpoint se recrea
la situación de una Pizzería-Cliente.