# Calc Server

This project is a service implementation of the [calc-api](https://github.com/aaronp/calc-api)

It was bootstrapped by copying the [example](https://github.com/aaronp/calc-api/tree/main/server-generated/v1/example).

I wanted this repo to just have a single file (the [Server.scala](./Server.scala)), just because I thought that would
look super slick (as that's all you need), but that looked weird when browsing in [github](https://github.com/aaronp/calc-api-service) 

# This Repository

Technically this entire repo could just be [Server.scala](./Server.scala), as it contains:
 * the documentation
 * the business logic
 * instructions for how to run/assemble/create a docker image

As cool as it would be to just have a single file in the repo, this repo includes:
 * [This Readme](./README.md) - this readme, because the repo looks weird on github without it. 
 * [Server.scala](./Server.scala) - the business logic and main entry point for serving up a REST service
 * [.gitignore](./.gitignore) - because it is annoying for git to want to add all those build files
 
# Running

As per the docs in [Server.scala](./Server.scala), you can just run `scala-cli Server.scala` and navigate to `localhost:8080`:

# Building

**NOTE:** This project has a dependency on the generated endpoint boilerplate code in the [calc-api](https://github.com/aaronp/calc-api/blob/main/build.sh).
In a typical project, the pipeline for that API would produce and publish that artefact, but for this example we've not bothered to do that.
Instead we just use 'publishLocal', so you will need to [check out the calc-api and run its build.sh](https://github.com/aaronp/calc-api/blob/main/build.sh)


This project can be built using [scala-cli](https://scala-cli.virtuslab.org):

* To simply run the project use:

  `scala-cli Server.scala`
* To create a runnable jar, run:

```bash
scala-cli --power package Server.scala -o app-assembly --assembly
java -jar app.jar
```

* To produce a docker image, run:

```bash
scala-cli --power package --docker Server.scala --docker-image-repository calc-server
docker run -p 8080:8080 calc-server:latest
```

* To generate an IDE project:

  `scala-cli setup-ide . --scala 3.3`
