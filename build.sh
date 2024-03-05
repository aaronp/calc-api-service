#!/usr/bin/env bash

export API_URL=${API_URL:-https://raw.githubusercontent.com/aaronp/calc-api/main/v1/service.yaml}
export JAR_PATH="./server/target/openapi-spring-1.0.0.jar"

installOpenApi() {
    echo "openapi-generator not found - installing with brew"
    brew install openapi-generator
}

# note - add a docker option for virtuslab/scala-cli:1.0.0 
installScalaCli() {
    echo "scala-cli not found - installing with brew"
    brew install Virtuslab/scala-cli/scala-cli
}

generateLocally() {
    which openapi-generator || installOpenApi
    echo "trying to generate server stubs from $API_URL"
    openapi-generator generate \
        -i "$API_URL" \
        -g spring \
        --config gen-config.json \
        -o server
}


generateWithDocker() {
    echo "generating stubs w/ docker from $API_URL"
    docker run --rm \
        -v ${PWD}:/local openapitools/openapi-generator-cli generate \
        -i "$API_URL" \
        -g spring \
        --config /local/gen-config.json \
        -o /local/server
}

compileServerJarWithDocker() {
    docker run -it --rm \
      --name my-maven-project \
      -v "$(pwd)/server":/usr/src/mymaven \
      -w /usr/src/mymaven \
      maven:3.6-jdk-11 \
      mvn clean install
}

ide() {
    which scala-cli || installScalaCli
	scala-cli setup-ide . --classpath ./server/target/openapi-spring-1.0.0.jar
}

jarExists() {
    [[ -f "${JAR_PATH}" ]] && echo "server jar exists at $JAR_PATH"
}

compile() {
   jarExists || compileServerJarWithDocker
}

generate() {
    jarExists || generateLocally || generateWithDocker
}