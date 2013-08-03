import java.util.NoSuchElementException

/**
 * Created by : Dmitry Karlinsky
 * Date: 8/3/13 12:02 PM
 */

sealed trait IntList
{
  def prepend(element: Int): IntList = Cons(element, this, this.length+1)
  def ::(element :Int): IntList  = prepend(element)
  def head: Int
  def tail: IntList
  def isEmpty: Boolean
  def foreach (function: Int => Unit)
  def length : Int

  def mkString(delimiter: String):String = {
      if(isEmpty) ""
      else
        if(tail.isEmpty)
          head.toString
        else
          head.toString + delimiter+tail.mkString(delimiter)

  }

  override def toString = {
     s"IntList(${mkString(",")})"
  }

}

private case class Cons(override val head: Int, override val tail :IntList, override val length: Int) extends IntList
{
  override def isEmpty = false

  def foreach(function: (Int) => Unit) = {
    function(head)
    tail.foreach(function)
  }


}

object IntNil extends IntList
{
  override def isEmpty = true

  override def head  = throw new NoSuchElementException("Nil.head")

  override def tail = throw new NoSuchElementException("Nil.tail")

  def foreach(function: (Int) => Unit) {}

  def length: Int = 0
}

object IntList
{
  def apply(elements: Int*): IntList =
  {
    if (elements.isEmpty) IntNil
    else elements.head :: apply(elements.tail:_*)
  }

}


