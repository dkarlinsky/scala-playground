package exercises.ex1

/**
 * Created by : Dmitry Karlinsky
 * Date: 7/31/13 5:39 PM
 */



trait Animal
{
  def name: String

  def kind = getClass.getSimpleName

  def describe = s"$kind $name"
}

trait Bird extends Animal
{
  def fly() = s"$describe flying"
}

trait WaterAnimal extends Animal
{
  def swim() = s"$describe swimming"
}

trait LandAnimal extends Animal
{
  def walk() = s"$describe walking"
}

case class Duck(name: String) extends Bird with WaterAnimal
case class Eagle(name: String) extends Bird
case class Lion(name: String) extends LandAnimal
case class Turtle(name: String) extends LandAnimal with WaterAnimal
case class Fish(name: String) extends WaterAnimal
case class Snake(name: String) extends Animal

class Zoo
{
  /**
   * creates a new Zoo with the given animal appended
   */
  def add(animal: Animal):Zoo = ???

  /**
   * creates a new Zoo with the given animal removed
   */
  def remove(animal: Animal): Zoo = ???

  override def toString: String  = ???

  /**
   * returns a string containing the results of the fly/walk/swim method for each animal, delimited by comma, followed by a single space
   * Priorities:
   * An animal that can fly will fly (even if it can move in other ways)
   * An animal that can't fly but can walk will walk  (even if it can move in other ways)
   */
  def moveAnimals1 :String = ???

  /**
   * returns a string containing the results of the fly/walk/swim method for each animal, delimited by comma, followed by a single space
   * Priorities:
   * An animal that can swim will swim (even if it can move in other ways)
   * An animal that can't swim but can walk will walk  (even if it can move in other ways)
   */
  def moveAnimals2 :String = ???

}
