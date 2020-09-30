import scala.annotation.tailrec

object NextGreatest extends App {

  val elements = Array(8,18)
  elements.sortInPlaceWith((x,y) => x>y).tail.headOption match {
    case Some(value) => println(value)
    case None => println(elements.head)
  }
}

object KthElementFromEndOfList extends App {
  val list = List(13,12,2,1,5,89)

  val k = 12

  list.takeRight(k).headOption match {
    case Some(element) => println(element)
    case None => throw new RuntimeException(s"Cannot process value of k: $k")
  }
}

object NextGreatestPermutation extends App {
  val digits = Array(1,2,3,5)
  val actual = digits.mkString.toInt

  println(nextMaximum(digits))

  @tailrec
  def nextMaximum(digits: Array[Int], take: Int = 2): Int = {
    if(take == digits.length || digits.length == 1) {
      actual
    }
    else {
      val permutationValue = permute(digits, take)
      if(permutationValue > actual){
        permutationValue
      }
      else {
        nextMaximum(digits, take + 1)
      }
    }
  }


  def permute(digits: Array[Int], take: Int): Int = {
    digits.takeRight(take).sortInPlaceWith((x,y) => x > y).prependedAll(digits.take(digits.length - take)).mkString.toInt
  }
}

object NextGreaterOptimalWay extends App {

  val array = Array(4,1,3,2,1,9,8,7,6,5) //

  val i = array.length - 1
  val j = i -1

  println(traverse(i,j).toList)

  @tailrec
  def traverse(i: Int, j: Int): Array[Int] = {
    if(array(j) < array(i)) {
      println(i)
      println(j)
      val nextGreater = elementToSwapWith(array, array(j),i)
      println(nextGreater)
      if(nextGreater != -1) {
        swap(j,nextGreater)
          .takeRight(i)
          .sortInPlaceWith((x,y) => x < y)
          .prependedAll(array.take(array.length - i))
          .toArray
      }
      else{
        traverse(i-1, j-1)
      }
    } else
      traverse(i-1, j-1)
  }

  @tailrec
  def elementToSwapWith(array: Array[Int], element: Int, fromIndex: Int, nextGreater: Int = -1, nextGreaterPosition: Int = -1): Int = {
    if(fromIndex == array.length){
      return nextGreaterPosition
    }
    if(array(fromIndex) > element){
        if(nextGreater != -1){
          if(nextGreater > element && nextGreater < array(fromIndex)){
            elementToSwapWith(array,element,fromIndex + 1, nextGreater, fromIndex)
          }
          else {
            elementToSwapWith(array, element, fromIndex + 1, array(fromIndex), fromIndex)
          }
        }
        else {
          elementToSwapWith(array, element, fromIndex + 1, array(fromIndex), fromIndex)
        }
      }
      else {
        elementToSwapWith(array, element, fromIndex + 1, nextGreater, nextGreaterPosition)
      }
  }

  def swap(p1: Int, p2: Int): Array[Int] = {
    val temp = array(p1)
    array(p1) = array(p2)
    array(p2) = temp
    array
  }
}
