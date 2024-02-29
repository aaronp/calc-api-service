# Calc Server

This project is a service implementation of the [calc-api](https://github.com/aaronp/calc-api)

# Building
There is a [Makefile](./Makefile) which knows how to generate the server code and package it up in a docker file using some 
utility [bash scripts found build.sh](./build.sh)

# Running
The default Make target runs the server, just type `make` and open [`localhost:8080/swagger-ui/index.html`](http://localhost:8080/swagger-ui/index.html)