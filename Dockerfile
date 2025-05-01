FROM openjdk:21-jdk-slim
COPY build/libs/cart-0.0.1-SNAPSHOT.jar cart.jar
ENV TZ=Asia/Seoul
ENTRYPOINT ["java", "-jar", "cart.jar"]