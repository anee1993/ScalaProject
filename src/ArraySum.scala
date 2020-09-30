object ArraySum extends App {

  val aList = List(1,2,3,4,5)

  val reducedList = aList.dropRight(1)

  println(reducedList)

  val map = Map(1 -> 2, 3 -> 4)

  val newMap = map.updated(1,6)

  println(newMap)

  val tupleList = Seq((100,233), (399, 90))
  println(tupleList)
}
