/**
 * Created by : Dmitry Karlinsky
 * Date: 8/25/13 6:08 PM
 */
val ints = Array(1,2,3)

val doubled = ints.map(_*2)

val objects: Array[Any] = ints  // doesn't compile

val objectSeq: IndexedSeq[Any] = ints

