##-- Source Build --##
# Docker container used to build the Clojure app
FROM clojure:openjdk-11-slim-buster as builder

# Environment settings
ENV APP_DIR=/usr/src/app

# Setup the directories
WORKDIR ${APP_DIR}

# Cache deps so they aren't fetched every time a .clj file changes
COPY build.clj ${APP_DIR}
COPY deps.edn ${APP_DIR}
RUN clj -P

# Copy source files and tests
COPY src/ ${APP_DIR}/src
COPY test/ ${APP_DIR}/test

# Test, build, and symlink to the built uberjar.
RUN ln -s "$(clj -T:build uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" ${APP_DIR}/app.jar

##-- Runtime --##
# Build the docker container with the above artifact that we will use in the lambda.
FROM eclipse-temurin:11-focal

WORKDIR /opt/app
COPY --from=builder /usr/src/app/app.jar app.jar

ENTRYPOINT [ "java", "-cp", "/opt/app/app.jar", "com.amazonaws.services.lambda.runtime.api.client.AWSLambda" ]
CMD ["aws_lambda_clj_scheduled.aws_lambda_clj_scheduled::handleRequest"]
