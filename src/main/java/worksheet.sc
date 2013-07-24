import scala.annotation.tailrec

/**
 * Created by : Dmitry Karlinsky
 * Date: 7/23/13 5:27 PM
 */
val foo = "bar"

def factorial(n:Int):Int ={
    if(n == 0)
      1
    else
      n * factorial(n-1)
}
factorial(6)

def betterFactorial(n:Int) = {

   @tailrec
   def iterate(accumulator:Int, n:Int):Int =
      if(n == 0)
        accumulator
      else
        iterate(accumulator * n, n-1)
   iterate(1, n)
}

betterFactorial(6)

def evenBetterFactorial(n: Int) = (1 to n).reduce(_ * _)

evenBetterFactorial(6)


