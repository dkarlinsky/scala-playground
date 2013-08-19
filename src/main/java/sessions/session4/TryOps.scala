package sessions.session4

import scala.util.Try

/**
 * Created by : Dmitry Karlinsky
 * Date: 8/8/13 4:49 PM
 */
object TryOps
{
    implicit class Divide(val value : Try[Int]) extends AnyVal
    {
        def / (by: Try[Int]) =
            for {
                nom <- value
                denom <- by
                div <- Try(nom/denom)
            } yield div

        def / (by: Int) =
            for {
                nom <- value
                div <- Try(nom/by)
            } yield div


    }
}
