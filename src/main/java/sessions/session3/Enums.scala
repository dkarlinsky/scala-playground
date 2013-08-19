package sessions.session3

/**
 * Created by : Dmitry Karlinsky
 * Date: 8/8/13 6:45 PM
 */

sealed trait MyEnum

object MyEnum
{
    object DMITRY extends MyEnum
    object ITSIK extends MyEnum
}

case class Unknown (str: String ) extends MyEnum




object WeekDay extends Enumeration {
    type WeekDay = Value
    val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
}

object Month extends Enumeration
{
    type Month = Value
    val Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec = Value
}




