# techstore
Tienda virtual usando Spring (Boot, JPA, Security)

*Proyecto de Diseño de Aplicaciones Web*\
Ulacit. Segundo cuatrimestre, 2020

*Integrantes*\
Eduardo Castillo Rodas\
Eduardo José Garrido Rivera\
Josué David Hernández Amador\
Michael Steven Monge Mora\
José David Mora Loría\
William Sebastian Rojas Ernest

## Instalación
1. Generar la base de datos. El archivo SQL se encuentra en */src/database/*
2. Duplicar el archivo application.properties.sample ubicado en */src/main/resources/*
3. Remover el .sample del nombre -> application.properties y reemplazar conexión con la base de datos
4. Instalar dependencias con el comando\
`$ mvn clean install`
6. Para correr el servicio usar el comando\
`$ mvn spring-boot:run`\
En caso de querer correr la aplicación en modo debug:\
`$ mvn spring-boot:run -Dspring-boot.run.fork=false`