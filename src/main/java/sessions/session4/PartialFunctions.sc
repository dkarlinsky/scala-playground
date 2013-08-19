/**
 * Created by : Dmitry Karlinsky
 * Date: 8/8/13 5:05 PM
 */

val pf:PartialFunction[Any, Int] = {case v:Int => v*2}
pf.isDefinedAt("Foo")
pf(10)

