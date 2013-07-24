import scala.annotation.tailrec

/**
 * Created by : Dmitry Karlinsky
 * Date: 7/23/13 5:51 PM
 */
object Factorial
{

    def naive(n: Int): Int =
       if (n == 0)
         1
       else
         n * naive(n - 1)


    def tailRec(n: Int)= {
      @tailrec
      def iter(accumulator: Int, i: Int):Int =
          if(i==0)
            accumulator
          else
            iter(accumulator * i, i-1)

       iter(1, n)

    }

    def cheating(n: Int) = (1 to n) reduce (_ * _)
}
