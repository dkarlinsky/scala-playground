/**
 * Created by : Dmitry Karlinsky
 * Date: 8/6/13 4:32 PM
 */

class Email(val email: String)
{

}

object Email
{
   def apply(email: String) = new Email(email)
   def unapplySeq(email: Email) = Some(email.email.split("@").toList)
}



def isFiftyoneEmail(email: String )= new Email(email) match {
  case Email(_, "fiftyone.com") => true
  case _ => false
}

isFiftyoneEmail("dmitry@e4x.com")
isFiftyoneEmail("dmitry@fiftyone.com")

