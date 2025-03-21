FROM openjdk:17-jdk-slim

# Configurar variables de entorno
ENV APP_HOME=/app
WORKDIR $APP_HOME

# Copiar solo los archivos necesarios
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src/ src/

# Construir la aplicación
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Copiar el archivo .jar generado
COPY target/*.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
