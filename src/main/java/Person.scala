import scala.beans.BeanProperty

/**
 * Created by : Dmitry Karlinsky
 * Date: 7/24/13 6:25 PM
 */

class Person (var age: Int, var name: String ) {
    var foo = "foo"
}

class PersonWithBeanProps(@BeanProperty var age: Int,
             @BeanProperty var name: String)

