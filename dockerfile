# =================================================================
# STAGE 1: BUILD (Compila o código Java e gera o JAR executável)
# =================================================================
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo de configuração do Maven para o cache
# Esta é uma otimização: se o pom.xml não mudar, o Docker usa o cache
COPY pom.xml .

# Baixa as dependências. O 'go-offline' é usado para pré-carregar tudo.
# Se o pom.xml for o único alterado, esta camada de dependências será reconstruída.
RUN mvn dependency:go-offline

# Copia o código fonte (tudo o que está na pasta src)
COPY src ./src

# Empacota a aplicação em um arquivo JAR executável.
# O 'clean install' compila o projeto e coloca o JAR em target/.
# O '-DskipTests' é usado para pular os testes durante a construção da imagem.
RUN mvn clean install -DskipTests

# =================================================================
# STAGE 2: RUNTIME (Prepara a imagem final, leve e segura, apenas para execução)
# =================================================================
# Usa uma imagem base Java menor e mais segura (JRE)
FROM eclipse-temurin:17-jre-alpine

# Define o diretório de trabalho para a execução
WORKDIR /app

# Argumento para pegar o nome do JAR da fase de 'build'
# O JAR_FILE será algo como /app/target/controle-estoque-0.0.1-SNAPSHOT.jar
ARG JAR_FILE=/app/target/*.jar

# Copia o JAR do estágio de build para o estágio de execução
COPY --from=build ${JAR_FILE} app.jar

# Expõe a porta que a aplicação Spring Boot usa (8080)
EXPOSE 8080

# Define o ponto de entrada. A aplicação será iniciada ao rodar o container
# Este comando executa o arquivo JAR copiado
ENTRYPOINT ["java", "-jar", "app.jar"]