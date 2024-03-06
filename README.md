# Calc Server

This project is a service implementation of the [calc-api](https://github.com/aaronp/calc-api)

It was bootstrapped by copying the [example](https://github.com/aaronp/calc-api/tree/main/server-generated/v1/example) directory of the generated server code,
and then implementing the business logic in Server.scala. 

The cool thing is, you actually only need a single file in this repo: the [Server.scala](./Server.scala).

We provide a [Dockerfile](./Dockerfile) just in case you want a zero-install build.

# Running

As per the docs in [Server.scala](./Server.scala), you can just run `scala-cli Server.scala` and navigate to `localhost:8080`:


# Building

There is a zero-install build with Docker:
```
docker build . -t calc:latest
```
 

Which builds this project using [scala-cli](https://scala-cli.virtuslab.org)

* To simply run the project use:

  `scala-cli Server.scala`
* To create a runnable jar, run:

  `scala-cli --power package Server.scala -o app-assembly --assembly`
* To produce a docker image (ignoring the  Dockerfile), run:

  `scala-cli --power package --docker Server.scala --docker-image-repository app-docker`

* To generate an IDE project:

  `scala-cli setup-ide . --scala 3.3`