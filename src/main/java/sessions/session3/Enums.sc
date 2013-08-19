
import sessions.session3.{Month, WeekDay}

/**
 * Created by : Dmitry Karlinsky
 * Date: 8/8/13 6:40 PM
 */

//class MyEnum extends Enumeration {
//   type EnumType = Value
//   val DMITRY, ITSIK = Value
//}

WeekDay.Fri


import WeekDay._

def isWorkingDay(d: WeekDay) = ! (d == Sat || d == Sun)

WeekDay.values filter isWorkingDay foreach println


WeekDay.values.find(_.toString == "Sunday")
WeekDay.values.find(_.toString == "Sun")


//isWorkingDay(Jan)





