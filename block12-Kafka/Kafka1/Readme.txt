12. Mensajería
Kafka
Nombre proyecto Maven: block12-kafka
Usando Kafka, montar dos aplicaciones: una que envíe mensajes y la segunda le responda con otros mensajes.


Primera versión de este ejercicio.

Dos aplicaciones independientes, un productor que envía mensajes a un Topic y un 
Consumer que los recibe.

Estos mensajes en esta versión tan solo son cadenas de String.

Se adjunta el fichero Postman donde a través de Endpoint se recrea
la situación de una Pizzería, donde el producer cada cierto tiempo
va actualizando el estado de la pizza y el cliente recibe cada actualización a 
través de consulta web.