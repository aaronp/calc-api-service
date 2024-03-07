//> using scala "3.3.1"
//> using lib "demo.rest::calc:0.0.1-SNAPSHOT"

/**
 * This project was bootstrapped by copying
 * [the generated example](https://github.com/aaronp/calc-api/tree/main/server-generated/v1/example)
 * directory of the generated server code and then just implementing the business logic.
 *
 * ==Building==
 * This project can be built using [scala-cli](https://scala-cli.virtuslab.org)
 *
 * $ To run the code: `scala-cli Server.scala`
 *
 * $ To create a runnable jar: scala-cli --power package Server.scala -o app-assembly --assembly
 *
 * $ To produce a docker image: scala-cli --power package --docker Server.scala --docker-image-repository app-docker
 *
 * $ To generate an IDE project: scala-cli setup-ide . --scala 3.3
 *
 * ==Testing==
 * The server will serve up a Swagger UI, which you can manually test by rnnning and navigating to http://localhost:8080
 * in your browser.
 *
 * We can add Server.test.scala as a [unit test](https://scala-cli.virtuslab.org/docs/cookbooks/introduction/test-only/),
 * but that was left out just because I thought it'd look cool to have a repo with a single file ;-)
 *
 * Another thought is that, as quick as the tests would be, you could actually run some test assertions as part of the
 * start-up (e.g. the core business logic would take sub-milliseconds to run). That's not typically done ... but why not?
 */

import demo.calc.BaseApp
import demo.calc.api.*
import demo.calc.model.*

/**
 * Our business logic - implement the 'calc' functions
 * @param calculateRequest the user request
 * @return the result of the calculation
 */
def calc(calculateRequest: CalculateRequest): BigDecimal =
  calculateRequest match {
    case CalculateRequest(lhs, CalculateRequest.OperatorEnum.add, rhs)      => lhs + rhs
    case CalculateRequest(lhs, CalculateRequest.OperatorEnum.subtract, rhs) => lhs - rhs
    case CalculateRequest(lhs, CalculateRequest.OperatorEnum.multiply, rhs) => lhs * rhs
    case CalculateRequest(lhs, CalculateRequest.OperatorEnum.divide, rhs)   => lhs / rhs
  }

/**
 * Out service implementation which needs to return a ServiceResponse.
 * (we simply delegate to our calc function)
 */
object CalcService extends DefaultService:
  override def calculate(request: CalculateRequest): ServiceResponse[Calculate200Response] =
    ServiceResponse(Calculate200Response(calc(request)))

object Main extends BaseApp(appDefaultService = CalcService):
  start()