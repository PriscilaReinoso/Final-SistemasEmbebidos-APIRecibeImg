#obtengo imagen para compilar
FROM maven:3.9-eclipse-temurin-17 AS builder

#copio archivos de la app a /app
WORKDIR /app
COPY . .

#creo jar
RUN mvn clean package -DskipTests

#obtengo imagen para ejecutar jar
FROM eclipse-temurin:17-jdk
#copiar el jar builder al contenedor final renombrandolo
COPY --from=builder /app/target/*.jar app.jar

#expone dentro del contenedor con el puerto 8080
EXPOSE 8080

#ejecuta la aplicacion al correr el contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]

