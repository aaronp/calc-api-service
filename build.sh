#!/usr/bin/env bash

export API_URL=${API_URL:-https://raw.githubusercontent.com/aaronp/calc-api/main/v1/service.yaml}

installOpenApi() {
    echo "openapi-generator not found - installing with brew"
    brew install openapi-generator
}

generateLocally() {
    which openapi-generator-cli || installOpenApi
    echo "trying to generate server stubs from $API_URL"
    openapi-generator-cli generate \
        -i "$API_URL" \
        -g spring \
        -o server
}


generateWithDocker() {
    echo "generating stubs w/ docker from $API_URL"
    docker run --rm \
        -v ${PWD}:/local openapitools/openapi-generator-cli generate \
        -i "$API_URL" \
        -g spring \
        -o /local/server
}

generate() {
    generateLocally || generateWithDocker
}