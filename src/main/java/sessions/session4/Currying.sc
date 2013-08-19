/**
 * Created by : Dmitry Karlinsky
 * Date: 8/8/13 5:23 PM
 */
def binaryOp[T] (op: (T,T)=>T ) (x: T) (y: T) = op(x,y)

val multiplyInts = binaryOp[Int](_ * _) _

val multiplyBy2 = multiplyInts(2)

val multXY = multiplyInts(2) (10)

val mult10by2 = multiplyBy2(10)


// single parameter list
def multyplyInts2 (x: Int, y: Int) = x*y

// the type of the function is not inferred for some reason
def multiplyBy2_2: Int=>Int = multyplyInts2(2, _)

val multiply20by2 = multiplyBy2_2(20)

