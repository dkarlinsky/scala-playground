


object helloWorld {

  implicit class FooInterpolation(val sc: StringContext) extends AnyVal {
    def foo(args: Any*) = (sc.parts, args)
  }

  def main(args: Array[String]) =
  {
    val name = "World"
    val string = s"Hello $name"

    println (string)

    println (foo"lala $name foo ${string.toLowerCase} yosef")

    new FooInterpolation(new StringContext("lala ","  foo ","  yosef")).foo(name, string)


  }

}
