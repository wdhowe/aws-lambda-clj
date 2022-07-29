# Docker container used to build the Clojure app
FROM clojure:openjdk-11-slim-buster as builder

ENV APP_DIR=/usr/src/app
WORKDIR ${APP_DIR}

# Cache deps so they aren't fetched every time a .clj file changes
COPY build.clj ${APP_DIR}
COPY deps.edn ${APP_DIR}
RUN clj -P

# Run tests and build
COPY src/ ${APP_DIR}/src
COPY test/ ${APP_DIR}/test
RUN clj -T:build ci

# Link to the built jar
RUN ln -s ${APP_DIR}/target/aws-lambda-clj-scheduled*.jar ${APP_DIR}/target/app.jar

# Build the docker container with the above artifact that we will use in the lambda.
FROM eclipse-temurin:11-focal

RUN mkdir /opt/app
COPY --from=builder /usr/src/app/target/app.jar /opt/app/app.jar

ENTRYPOINT [ "java", "-cp", "/opt/app/app.jar", "com.amazonaws.services.lambda.runtime.api.client.AWSLambda" ]
CMD ["aws_lambda_clj_scheduled.aws_lambda_clj_scheduled::handleRequest"]
