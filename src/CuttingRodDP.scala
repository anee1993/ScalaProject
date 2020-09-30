object CuttingRodDP extends App {

  val priceArray = Array(1,5,8,9,10,17,17,20)
  val length = priceArray.length

  val table = Array.ofDim[Int](length,length)

  for(i <- 0 until length) {
    table(i)(i) = priceArray(i)
  }

  for(minPos <- 2 to length) {
    for(i <- 0 until length - minPos + 1) {
      val j = minPos + i - 1
      table(i)(j) = table(i)(j-1) + 1
    }
  }
}