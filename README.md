# Calc Server

This project is a service implementation of the [calc-api](https://github.com/aaronp/calc-api)

It was bootstrapped by copying the [example](https://github.com/aaronp/calc-api/tree/main/server-generated/v1/example).

I wanted this repo to just have a single file (the [Server.scala](./Server.scala)), just because I thought that would
look super slick (as that's all you need), but that looked weird when browsing in [github](https://github.com/aaronp/calc-api-service) 

# Running

As per the docs in [Server.scala](./Server.scala), you can just run `scala-cli Server.scala` and navigate to `localhost:8080`:


# Building


Which builds this project using [scala-cli](https://scala-cli.virtuslab.org)

* To simply run the project use:

  `scala-cli Server.scala`
* To create a runnable jar, run:

  `scala-cli --power package Server.scala -o app-assembly --assembly`
* To produce a docker image (ignoring the  Dockerfile), run:

  `scala-cli --power package --docker Server.scala --docker-image-repository app-docker`

* To generate an IDE project:

  `scala-cli setup-ide . --scala 3.3`