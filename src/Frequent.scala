import scala.annotation.tailrec

object Frequent extends App {


  val array = Array(1, 2, 1, 1, 3, 4, 5, 6, 6, 6, 7, 8, 8, 8, 8, 9, 6, 6)

  val distinct = array.distinct

  val frequencyCount = new Array[Int](distinct.length)

  val tuple = (distinct zip frequencyCount).toMap

  println(recurseAndPutIntoMap(array, tuple))

  @tailrec
  def recurseAndPutIntoMap(array: Array[Int], map: Map[Int, Int], max: Int = 0): Int = {
    if (array.isEmpty) {
      max
    }
    else {
      val head = array.head
      val value = map(head)
      if (value > max) {
        recurseAndPutIntoMap(array.tail, map.updated(head, value + 1), head)
      }
      else {
        recurseAndPutIntoMap(array.tail, map.updated(head, value + 1), max)
      }
    }
  }
}
