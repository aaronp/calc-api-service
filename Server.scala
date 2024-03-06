//> using scala "3.3.1"
//> using lib "demo.rest::calc:0.0.1-SNAPSHOT"

import demo.calc.BaseApp
import demo.calc.api.*
import demo.calc.model.*

def calc(calculateRequest: CalculateRequest): BigDecimal =
  calculateRequest match {
    case CalculateRequest(lhs, CalculateRequest.OperatorEnum.add, rhs) => lhs + rhs
    case CalculateRequest(lhs, CalculateRequest.OperatorEnum.subtract, rhs) => lhs - rhs
    case CalculateRequest(lhs, CalculateRequest.OperatorEnum.multiply, rhs) => lhs * rhs
    case CalculateRequest(lhs, CalculateRequest.OperatorEnum.divide, rhs) => lhs / rhs
  }

val myDefaultService = new DefaultService:
  override def calculate(request: CalculateRequest): ServiceResponse[Calculate200Response] =
    val result = calc(request)
    ServiceResponse(Calculate200Response(result))

// the Main entry point
object Server extends BaseApp(appDefaultService = myDefaultService):
  start()