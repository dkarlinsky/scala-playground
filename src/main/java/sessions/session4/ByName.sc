import scala.Boolean

/**
 * Created by : Dmitry Karlinsky
 * Date: 8/8/13 5:16 PM
 */

def ifThenElse[T](condition: => Boolean) (thenExpr: => T) (elseExpr: => T ) =
  if(condition)
      thenExpr
  else
      elseExpr


ifThenElse{ false }{
    println("Evaluating then branch")
    "then"
}{
    println("Evaluating else branch")
    "else"
}



