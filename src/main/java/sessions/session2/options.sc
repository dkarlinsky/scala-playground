/**
 * Created by : Dmitry Karlinsky
 * Date: 8/3/13 11:42 AM
 */

def maybeNumber = {
  val n = Math.random()
  if(n < 0.5) None
  else Some(n)
}

// access using pattern matching
maybeNumber match {
  case None => "nothing"
  case Some(n) => n.toString
}

// access using for comprehension

for { n <- maybeNumber} yield n.toString   // the result is of type Option[String]


// Chained operations on Option
case class Address(
                    street1: String,
                    street2: Option[String],
                    street3: Option[String],
                    city: String,
                    region: Option[String],
                    country: String

                    )

case class Account(number: String, name: String, address: Option[Address])

val account: Option[Account] = Some(Account("15566", "John Smith", Some(
    Address(
      "1 sesame str",
      Some("suite 111"),
      None,
      "NYC",
      Some("ny"),
      "US"))
))


// now we want to get the account.address.region if it in upper case

for {
  acc <- account
  address <- acc.address
  region <- address.region
} yield region.toUpperCase




