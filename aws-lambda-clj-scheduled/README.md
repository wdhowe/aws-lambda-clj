# aws-lambda-clj-scheduled

This project was created based on [this blog post](https://wtfleming.github.io/blog/clojure-aws-lambda/).

This is a Clojure (JVM based) AWS Lambda function in Docker, running on a schedule.

## Pre-reqs

Install Clojure and the Leiningen Project Tool

* [Clojure](https://gist.github.com/wdhowe/e6fc5e372b85ad8a25fdebf446b1a3e6)
* [Leiningen](https://gist.github.com/wdhowe/78bececa96e577bf26139e4bdc501d47)

Install AWS SAM

```bash
pip3 install aws-sam-cli
```

## Build

Build the container and serverless app.

```bash
# Any change to the sam template.yaml requires a 'sam build'.
sam build
```

## Test

Test the Lambda function locally.

```bash
sam local invoke --event test/aws_lambda_clj_scheduled/resources/scheduled_event.json
```

## Deploy

Deploy with prompts.

```bash
sam deploy --guided
```

Deploy with a specific aws cli credential profile and prompts.

```bash
sam deploy --profile MY-AWS-PROFILE --guided
```

Deploy without prompts.

```bash
sam deploy \
--stack-name MY-STACK-NAME \
--s3-bucket MY-BUCKET \
--capabilities CAPABILITY_IAM \
--resolve-image-repos \
--no-fail-on-empty-changeset \
--region us-west-2 \
--profile default
```

## Monitor

Watching deployment logs.

```bash
sam logs --stack-name MY-STACK-NAME
```

## Manage

Deleting the deployment.

```bash
sam delete --stack-name MY-STACK-NAME
```

## License

Copyright © 2022-2024 Bill Howe

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
<http://www.eclipse.org/legal/epl-2.0>.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at <https://www.gnu.org/software/classpath/license.html>.

----
