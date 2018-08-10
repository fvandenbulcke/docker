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