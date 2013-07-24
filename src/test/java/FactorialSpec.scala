import com.sun.javaws.exceptions.InvalidArgumentException
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

/**
 * Created by : Dmitry Karlinsky
 * Date: 7/23/13 5:57 PM
 */
class FactorialSpec extends FlatSpec with ShouldMatchers
{
  "naive Factorial of 6 " should "be 720" in {
    Factorial.naive(6) should equal( 720)
  }

  "tailRec Factorial of 6 " should "be 720" in {
    Factorial.tailRec(6) should equal( 720)
  }

  "cheating Factorial of 6 " should "be 720" in {
    Factorial.cheating(6) should equal( 720)
  }

  "naive Factorial of -1 " should "throw exception" in {
     evaluating (Factorial.tailRec(-1)) should produce [InvalidArgumentException]
  }
}
