##-- Source Build --##
# Docker container used to build the Clojure app
FROM clojure:openjdk-11-lein as builder

# Environment settings
ENV APP_DIR=/usr/src/app

# Setup the directories
WORKDIR ${APP_DIR}

# Download application dependencies
COPY project.clj ${APP_DIR}
RUN lein deps

# Copy source files and tests
COPY src/ ${APP_DIR}/src
COPY test/ ${APP_DIR}/test

# Test, build, and symlink to the built uberjar.
RUN lein test && \
    ln -s "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app.jar

##-- Runtime --##
# Build the docker container with the above artifact for use in the lambda.
FROM eclipse-temurin:11-focal

WORKDIR /opt/app
COPY --from=builder /usr/src/app/app.jar app.jar

ENTRYPOINT [ "java", "-cp", "/opt/app/app.jar", "com.amazonaws.services.lambda.runtime.api.client.AWSLambda" ]
CMD ["aws_lambda_clj_scheduled.core::handleRequest"]
