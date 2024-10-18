# This build target is for the sam template and local invoke tests.
# It gets executed during "sam build"
build-BBLambda:
	bb blambda build-all
	unzip ./target/handler.zip -d $(ARTIFACTS_DIR)/
