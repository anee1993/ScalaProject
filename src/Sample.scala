object Sample extends App {
  (1 to 100).foreach(x => println(s"Scala rocks times $x"))

  val anEither: Either[String, Int] = Right(100)

  val incremented = anEither.map(x => x+1)

  println(incremented.merge)
}
