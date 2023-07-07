# 1st stage, build the app
#FROM  pcaifocnrd01.sdc.raj.gov.in:5000/maven:3.6-jdk-11 as build
FROM docker.io/maven:3.6-jdk-11 as build
WORKDIR /pssservices

# Create a first layer to cache the "Maven World" in the local repository.
# Incremental docker builds will always resume after that, unless you update
# the pom
ADD pom.xml .
RUN mvn package -Dmaven.test.skip

ADD src src

# Do the Maven build!
# Incremental docker builds will resume here when you change sources

RUN mvn package -DskipTests
RUN echo "done!"

# 2nd stage, build the runtime image
#FROM pcaifocnrd01.sdc.raj.gov.in:5000/openjdk:11.0.4-jre-slim
FROM docker.io/openjdk:11.0.4-jre-slim
WORKDIR /pssservices


# Copy the binary built in the 1st stage
COPY --from=build /pssservices/target/pssServices.jar ./
COPY --from=build /pssservices/target/libs ./libs

CMD ["java", "-jar", "pssServices.jar"]

EXPOSE 8089
