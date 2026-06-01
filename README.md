# Chat RMI
## Índice
- [Descripción General](descripción-general)
- [Características Principales](características-principales)
- [Manual de Usuario](manual-de-usuario)
  - [Requisitos previos](requisitos-previos)
  - [Estructura del proyecto](estructura-del-proyecto)
  - [Ejecutar-aplicación](ejecutar-aplicación)
- [Autor](autor)        
## Descripción General
Este proyecto consiste en el desarrollo de una aplicación de chat distribuido utilizando Java RMI
Cada instancia de la aplicación actúa simultáneamente como cliente y servidor RMI, permitiendo que dos usuarios intercambien mensajes mediante invocaciones remotas sin necesidad de un servidor central dedicado.
La aplicación implementa una comunicación punto a punto (P2P) donde cada usuario publica un servicio remoto para recibir mensajes y, al mismo tiempo, consume el servicio remoto del otro usuario para enviar mensajes.
## Características Principales
-Comunicación distribuida mediante Java RMI.
-Arquitectura P2P (Peer to Peer).
-Interfaz gráfica desarrollada con Java Swing.
-Envío y recepción de mensajes en tiempo real.
-Serialización de mensajes mediante objetos Java.
-Registro dinámico de usuarios.
-Comunicación bidireccional entre dos JVM independientes.

## Manual de Usuario
### Requisitos previos:
-**JDK 17 o superior**
-**Apache NetBeans (recomendado)**
**Maven**
### Estructura del proyecto
```
src
└──main
    └── java
        └── com
            └── mycompany
                └── proyectormi
                    ├── Node 
                        └── ChatNode.java
                    ├── cliente 
                          └── RMIClient.java
                    ├── server 
                          └── RMIServer.java
                    ├── service 
                          ├── ChatService.java 
                          └── ChatServiceImpl.java
                    ├── model 
                          └── ChatMessage.java
                    └── pantalla
                          ├── ChatWindow.java
                          └── RegisterWindow.java
```
### Ejecutar aplicación
Abriremos en este caso en el IDE el proyecto ProyectoRMI y le daremos a ejecutar, con ello nos aparecerá una pantalla de registro de usuario donde indicaremos el nombre, en este caso esta hecho para dos usuarios(Nico y Pedro) por lo q en el primer usuario 
le daremos a Nico y este se conectará en el puerto correspondiente abriendo la pantalla del chat, después de esto, ejecutaremos otra instancia del proyecto, y nos registraremos con el otro usuario restante, volviendonos a aparecer en este caso la pantalla 
del chat, en caso de las dos instancias, aparece el mensaje enviado por el usuario y el usuario q lo envio tanto en una como en la otra pantalla

## Autor
- **Nicolás Sanjuas Casal**

