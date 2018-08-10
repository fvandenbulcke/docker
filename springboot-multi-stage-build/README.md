SpringBoot Docker Project!
-------------------

<p align="center">
  <a href="https://spring.io/guides/gs/spring-boot/">
    <img src="./readme/spring-boot.png" height="100"/>
  </a>
  <a href="https://www.docker.com/">
    <img src="https://www.docker.com/sites/default/files/vertical_large.png" height="100"/>
  </a>
</p>

## Description

This project present how dockerize a springboot project using <a href="https://docs.docker.com/develop/develop-images/multistage-build/">multi-stage build</a>. It need maven and application configuration files present in the folder <a href="https://github.com/fvandenbulcke/springboot/tree/master/sb-rest-api-docker/docker">*docker*</a>.


## Start application as Docker container

#### Step1 : Image creation

The first step is based on a maven image to build the app sources. It has been referenced as *builder* : 

```bash
FROM maven:3.5.2-jdk-8 as builder

LABEL authors="Florian Vandenbulcke <florian.vandenbulcke@hotmail.fr>"

# Create volume for maven dependencies load
VOLUME /opt/maven

# Copy project sources and maven settings
COPY /src /src
COPY pom.xml .
COPY /docker/maven_settings.xml .

# Build the application
RUN mvn -s /maven_settings.xml clean install
```

```bash
docker build -t springboot .
```

#### Step2 : Application run

The second step is based on a java image to create container with the .jar from the step *builder* and specific configuration.
As recommended by <a href="https://docs.docker.com/install/linux/linux-postinstall/#manage-docker-as-a-non-root-user">Docker</a>, a non-root user is created to start the container: 

```bash
FROM java:8-jre

# Create the group and app user
RUN groupadd  app
RUN useradd -G app 1001

# Add the executable jar
COPY --from=builder /target/springboot.jar .

# Add spring configuration
COPY /docker/application.yml .

# Remove the temporary folders
RUN rm -rf /opt/

# Change to the app user.
USER 1001

# Expose the app port
EXPOSE 8080

# Launch the application
CMD ["java","-jar","/springboot.jar"]
```


```bash
docker run -p 8080:8080 --name springboot springboot:latest
```
