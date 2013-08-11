package solutions.ex1

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

case class Zoo(animals: List[Animal] )
{
  def this() = {
    this(Nil)
  }

  def add(animal: Animal):Zoo = Zoo(animal :: animals)

  def remove(animal: Animal): Zoo = Zoo(animals filter (_ != animal))

  override def toString: String  = animals.reverse.map(_.describe).mkString(", ")

  def moveAnimals1 :String = animals.reverse.map(_ match {
    case bird: Bird => bird.fly()
    case l : LandAnimal => l.walk()
    case w: WaterAnimal => w.swim()
    case animal: Any => s"${animal.describe} can't move "
  }).mkString(", ")

 def moveAnimals2 :String = animals.reverse.map(_ match {
    case w: WaterAnimal => w.swim()
    case l : LandAnimal => l.walk()
    case bird: Bird => bird.fly()
    case animal: Any => s"${animal.describe} can't move "
  }).mkString(", ")

}
