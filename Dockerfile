# Usar la imagen base de OpenJDK 17 jdk alpine
FROM openjdk:17-jdk-alpine

# Copiar el artefacto JAR en el contenedor
COPY target/*.jar app.jar

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java","-jar","/app.jar"]