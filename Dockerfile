# Используем официальный образ OpenJDK 17
FROM openjdk:17-jdk-slim

# Указываем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файл JAR в контейнер
COPY target/spring-boot_security-demo-0.0.1-SNAPSHOT.jar /app/spring-boot_security-demo-0.0.1-SNAPSHOT.jar

# Запуск Java приложения
CMD ["java", "-jar", "spring-boot_security-demo-0.0.1-SNAPSHOT.jar"]