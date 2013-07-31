package exercises.ex1

import org.scalatest.FunSuite

/**
 * Created by : Dmitry Karlinsky
 * Date: 7/31/13 6:06 PM
 */
class ZooTest extends FunSuite
{

  trait Fixture {
    val zoo = new Zoo().
      add(Lion("Mitzi")).
      add(Eagle("Shooki")).
      add(Duck("Donald")).
      add(Lion("Simba")).
      add(Duck("Scrooge")).
      add(Fish("Goldie")).
      add(Turtle("Tank"))
  }

  test("test that moveAnimals1 uses appropriate transportation methods for each"){

    new Fixture {

      assert(zoo.moveAnimals1 ===
        "Lion Mitzi walking, Eagle Shooki flying, Duck Donald flying, Lion Simba walking, Duck Scrooge flying, Fish Goldie swimming, Turtle Tank walking"
      )

    }
  }

  test("test that moveAnimals2 uses appropriate transportation methods for each"){

    new Fixture {

      assert(zoo.moveAnimals2 ===
        "Lion Mitzi walking, Eagle Shooki flying, Duck Donald swimming, Lion Simba walking, Duck Scrooge swimming, Fish Goldie swimming, Turtle Tank swimming"
      )

    }
  }

}