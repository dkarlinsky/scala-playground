package sessions.session3

class B
class C extends B

class GetBox[+A](val a: A) {

    def get :A = a

}

class PutBox[-A]{
   def put(value:A):Unit = println(value)
}



//object Test extends App
//{
//    val gb:GetBox[B,B] = new GetBox[B,B](new C)
//    val c:B=gb.get
//}



//object Test{
//    def putC(x:PutBox[C]) :Unit = x.put(new C)
//    def getB(y:GetBox[B]) :B = y.get
//    val tempB = new PutBox[B]{}
//    val tempC = new GetBox[C]{}
//    putC(tempB)
//    getB(tempC)
//}
