import scala.collection.mutable.ListBuffer

object MinimumCoins extends App {

  val coins = Array(5,4,3,2,15,6,1)

  val sum = 12
  val buffer = new ListBuffer[Iterator[Array[Int]]]

  for(i <- 1 to coins.length) {
    val combos = coins.combinations(i)
    buffer += combos
  }

  val allCombos = buffer.flatMap(iterator => iterator.map(combinationList => (combinationList, combinationList.sum)))

  val possibleSolutions = allCombos.filter(x => x._2 == sum).sortBy(_._1.length).map(x => (x._1.toList,x._2))

  val costEffectiveSolution = possibleSolutions.head

  println(costEffectiveSolution.toString())
}
