import scala.collection.mutable.ListBuffer

object Subsets extends App {

  val anArray = Array(1,2,3,4)
  val buffer = new ListBuffer[Iterator[Array[Int]]]

  for(i <- 1 to anArray.length) {
    val combos = anArray.combinations(i)
    buffer += combos
  }
  val massagingArray = buffer.flatMap(x => x.toList.map(y => y.toList))

  massagingArray.foreach(println)
}
