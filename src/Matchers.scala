import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object Matchers extends App {

  val nums = (1 to 26).toList
  val alphbets = List("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
    "U", "V", "W", "X", "Y", "Z")

  val numAlphaMap = (nums zip alphbets).toMap

  val inputString = "1234"

  val givenNumberList = inputString.toCharArray

  println(numAlphaMap)
  println(givenNumberList.toList)

  val notPossibleBuffer = new ListBuffer[String]

  val basicMatch = givenNumberList.map(x => numAlphaMap(x.asDigit)).mkString

  println(basicMatch)

  val finalResult = (mapIterator(givenNumberList) :+ basicMatch).filterNot(x => x.length == 1)

  println(finalResult)

  @tailrec
  def mapIterator(arr: Array[Char], result: List[String] = List()): List[String] = {
    if(arr.isEmpty){
      result
    }
    else{
      val head = arr.head.asDigit
      val firstTwo = arr.take(2).mkString.toInt
      val primaryCombo = recursiveFinder(head.toString, arr.takeRight(arr.length - 1), List.empty[String] :+ numAlphaMap(head))
      val cipher = {
        if(firstTwo <= 26)
          recursiveFinder(firstTwo.toString, arr.takeRight(arr.length - 2), List.empty[String] :+ numAlphaMap(firstTwo))
        else
          ""
      }

      if(cipher.nonEmpty){
        mapIterator(arr.takeRight(arr.length - 2), result :+ primaryCombo :+ cipher)
      }
      else {
        mapIterator(arr.takeRight(arr.length - 1), result :+ primaryCombo)
      }
    }
  }
  recursiveFinder(givenNumberList.head.toString, givenNumberList, List(numAlphaMap(givenNumberList.head.asDigit)))

  def recursiveFinder(dominant: String, remaining: Array[Char], result: List[String]): String = {
    if (remaining.isEmpty) {
        result.mkString
    }
    else {
      if (remaining.length == 1) {
        recursiveFinder(dominant, remaining.tail, result)
      }
      else if (remaining.length == 2) {
        if (remaining.mkString.toInt <= 26) {
          recursiveFinder(dominant, remaining.drop(2), result :+ numAlphaMap(remaining.mkString.toInt))
        }
        else {
          recursiveFinder(dominant, remaining.takeRight(1), result)
        }
      }
      val takingOne = remaining.head.asDigit
      val takingFirstTwo = remaining.take(2).mkString
      val matchFound = numAlphaMap.get(takingFirstTwo.toInt)

      matchFound match {
        case Some(value) => recursiveFinder(dominant, remaining.takeRight(remaining.length - 2), result :+ value)
        case None => recursiveFinder(dominant, remaining.takeRight(remaining.length - 1), result :+ numAlphaMap(takingOne))
      }
    }
  }

  def findIfNumberHasAPair(number: Int): Option[String] = {
    numAlphaMap.get(number)
  }
}
