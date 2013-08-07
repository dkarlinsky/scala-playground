/**
 * Created by : Dmitry Karlinsky
 * Date: 8/6/13 4:22 PM
 */

case class Family(mom: String, dad: String, kids: String* )

Family(mom="Alice", dad="Bob")
Family(dad="Bob", mom="Alice")



Family(dad="Bob", mom="Alice", kids="Carol")

