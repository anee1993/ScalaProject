import scala.annotation.tailrec

object kthElement extends App {

  val n = 3

  val node = Node(1, Node(2, Node(3, Node(4, Node(5, Node(6, null))))))
  case class Node(data:Int, next: Node)

  //val aList = List(1,2,3,4,5,6)

  val start = node

  val end = traverseTillKthNode(n-1, start)

  println(start.data)
  println(end.data)
  println(fromTheEnd(start,end))

  @tailrec
  def fromTheEnd(start: Node, end: Node): Int = {
    if(null == end.next) {
      start.data
    }
    else {
      fromTheEnd(start.next, end.next)
    }
  }

  @tailrec
  def traverseTillKthNode(k: Int, start: Node): Node = {
    if(k == 0 || null == start){
      start
    }
    else {
      traverseTillKthNode(k - 1, start.next)
    }
  }
}

object NextGreatestElement extends App {

  val array = Array(2, 4, 12, 445, 18, 100)
  val length = array.length

  val secondGreatest = singlePassSecondGreatest(array, length)

  println(secondGreatest)

  @tailrec
  def singlePassSecondGreatest(array: Array[Int], length: Int, first: Int = -1, second: Int = -1): Int = {
    if(length == 0){
      second
    }
    else {
      val head = array.head
      if(head > first) {
        singlePassSecondGreatest(array.tail, length - 1, head, first)
      }
      else if(head > second) {
        singlePassSecondGreatest(array.tail, length - 1, first, head)
      }
      else {
        singlePassSecondGreatest(array.tail, length -1, first, second)
      }
    }
  }
}

object MostFrequent extends App {

  val array = Array(1,3,2,1,4,1,4,4,5,1,5,5,1,5,6)

  println(singlePass(array, array.length))

  @tailrec
  def singlePass(array: Array[Int], length: Int, map: Map[Int,Int] = Map()): Int = {
    if(length == 0){
      map.toSeq.maxBy(_._2)._1
    }
    else{
      val head = array.head
      if(map.contains(array.head)){
        val currentValue = map(head)
        singlePass(array.tail, length -1, map ++ Map(head -> (currentValue + 1)))
      }
      else {
        singlePass(array.tail, length - 1, map ++ Map(head -> 1))
      }
    }
  }
}
