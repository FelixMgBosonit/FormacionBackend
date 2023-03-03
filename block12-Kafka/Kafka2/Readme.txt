12. Mensajería
Kafka
Nombre proyecto Maven: block12-kafka
Usando Kafka, montar dos aplicaciones: una que envíe mensajes y la segunda le responda con otros mensajes.


Segunda versión de este ejercicio.

Dos aplicaciones independientes, un productor que envía mensajes a un Topic y un 
Consumer que los recibe.

A diferencia de la primera versión en este caso se envían objetos del tipo pedido.

Se adjunta el fichero Postman donde a través de Endpoint se recrea
la situación de una Pizzería, donde el producer cada cierto tiempo
va actualizando el estado de la pizza y el cliente recibe cada actualización a 
través de consulta web.