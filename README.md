# Actividad 2: Persistencia de datos con Room
Este proyecto consiste en una aplicación Android creada con Jetpack Compose y Room para guardar un historial de propinas ingresadas por el usuario. 
Utiliza un ViewModel para mantener una arquitectura limpia y separada entre la interfaz y los datos.

# Tecnologías utilizadas
- Kotlin
- Android Jetpack Compose
- Room (persistencia local)
- ViewModel y StateFlow
- Android Studio

# Objetivo
Implementar un sistema de almacenamiento persistente usando la biblioteca Room, para permitir guardar y recuperar datos
en una base de datos SQLite a través de una interfaz moderna y reactiva.

# Estructura del proyecto
TipDao.kt → DAO con operaciones de base de datos
TipDatabase.kt → Base de datos con singleton Room
TipViewModel.kt → ViewModel con lógica de negocio y estado
TipScreen.kt → Interfaz de usuario en Compose
MainActivity.kt → Punto de entrada de la app

