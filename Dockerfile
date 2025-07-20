FROM mcr.microsoft.com/devcontainers/base:ubuntu

# Install Java 21 and Maven
RUN apt update && \
    apt install -y openjdk-21-jdk maven && \
    apt clean

ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH
