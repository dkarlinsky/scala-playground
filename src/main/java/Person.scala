import scala.beans.{BooleanBeanProperty, BeanProperty}

/**
 * Created by : Dmitry Karlinsky
 * Date: 7/24/13 6:25 PM
 */

class Person (var age: Int, var name: String, var cool: Boolean ) {

    println(s"initilizing(1): $name is $age")


    def this(age: Int, name: String)= this(age, name, name equalsIgnoreCase  "dmitry")

    println(s"initilizing(2): $name is $age")

    def adult = age >=18

    def incrementAgeBy(n: Int) = { age = age + n}
}

class PersonWithBeanProps(@BeanProperty var age: Int,
             @BeanProperty var name: String,
             @BooleanBeanProperty var cool: Boolean)
{
    def this(age: Int, name: String)= this(age, name, name equalsIgnoreCase  "dmitry")
}

class PersonNoVarsVals(name: String, age: Int)
{
    def foo = s"$name is $age"
    def getName = name
    def getAge = age

}


class PersonNoCtor{
   var name: String =""
   var age: Int = 0

}

