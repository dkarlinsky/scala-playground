import scala.util.Try
import sessions.session4.TryOps
import TryOps.Divide

/**
 * Created by : Dmitry Karlinsky
 * Date: 8/8/13 4:47 PM
 */
def parseInt(str: String) = Try(Integer.parseInt(str))

parseInt("10") / parseInt("2")

parseInt("10") / 2

parseInt("10") / parseInt("0")

parseInt("10.5") / parseInt("0")

parseInt("10") / parseInt("0")

def toInt(t: Try[Int]) = t.recover {
    case e: NumberFormatException => -1
    //case e: ArithmeticException => 42
}.get


val divByZeroToInt = toInt(parseInt("10") / parseInt("0"))
























































val badNumberToInt = toInt(parseInt("foo"))


val parseFooGetOrElse = parseInt("foo").getOrElse {
    println("handling error")
    "Error"
}

val parse2GetOrElse = parseInt("2").getOrElse {
    println("handling error")
    "Error"
}
