# Programación Reactiva
## 1. Conceptos básicos
###  ¿Qué es la programación reactiva?
* Modelo de computación que puede ser alterado por cierto tipo de eventos los cuales pueden ser procesados o ignorados.
* Es una técnica de programación  en la que las tareas a realizar se ejecutan de manera asíncrona. Esta ejecución está regida o dirigida con respecto a la ocurrencia de eventos  (event-driven).  
* Este esquema de procesamiento asíncrono se emplea principalmente para manejar grandes cantidades de flujos de información de forma continua. *"Sistemas reactivos reaccionan a los datos a través de la ejecución de código asociado a diversos eventos"*
* Algunas tecnologías de uso:
	* message-passing framework
	* Ejecución asíncrona  de tareas basado en el concepto de event-driven tasks.
* Beneficios
	* Escalabilidad horizontal:  Manejo de grandes cantidades de eventos.
	* Implementación de componentes con un bajo acoplamiento, fallas pueden ser aisladas fácilmente. 

#### Patrón de diseño Observer
La programación reactiva está basada en este patrón:
* Cuando el estado de un objeto cambia, dicho evento es notificado a otros objetos, y se realiza alguna acción. 
* Una aplicación puede hacer *polling*, es decir, puede preguntar continuamente si ha ocurrido algún cambio (evento).
* En programación reactiva, en lugar de hacer polling,  se hace *pushing*, es decir, cuando ocurre  un evento, se realiza una notificaciò 
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE1MDk4NTY5MjZdfQ==
-->