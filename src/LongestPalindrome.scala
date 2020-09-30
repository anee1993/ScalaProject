import scala.annotation.tailrec

object LongestPalindrome extends App {

  val inputString = "GEEKSFORGEEKS"
  val length = inputString.length
  val charArray = inputString.toCharArray.toList

  val table = Array.ofDim[Int](length,length)

  for(i <- 0 until length) {
    table(i)(i) = 1
  }

  for(minLen <- 2 to length) {
    for(i <- 0 until length-minLen+1) {
      val j = i+minLen-1
      if(charArray(i) == charArray(j) && minLen == 2){
        table(i)(j) = 2
      }
      else if(charArray(i) == charArray(j)){
        table(i)(j) = table(i+1)(j-1) + 2
      }
      else {
        table(i)(j) = Math.max(table(i)(j-1), table(i+1)(j))
      }
    }
  }

  println(table(0)(length-1))
}
