FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copia tudo para dentro da imagem
COPY . ./

# Dá permissão de execução ao Maven Wrapper
RUN chmod +x mvnw

# Faz o build da aplicação (gera o JAR dentro de target/)
RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install

# Expõe a porta padrão do Spring Boot
# EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "target/Labor-future-0.0.1-SNAPSHOT.jar"]
