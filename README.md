# El Tiempo

Proyecto app meteorológica de Diego Rodriguez Barcala

Esta aplicación se ha desarrollado utilizando las siguientes tecnologías:
  - Kotlin y Jetpack Compose (Codificación y diseño de la interfaz)
  - Dagger Hilt (Inyección de dependencias)
  - Retrofit2 (conexión y recuperación de datos desde una API)
  
Se ha utilizado el patrón MVVM y arquitectura limpia para estructurar el proyecto.

El funcionamiento básico de la aplicación permite mostrar la información meteorológica de la ubicación del dispositivo.
Para ello, es necesario que el usuario otorgue permisos de ubicación a la aplicación, de lo contrario se mostrará una advertencia.
Si el usuario otorga permisos y activa la ubicación en el dispositivo, se mostrará la información recopilada desde la API sobre la información meteorológica en esa ubicación.


