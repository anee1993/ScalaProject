import scala.annotation.tailrec

object DS1 extends App {

  val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)

  val k = 3

  val n = (list.length - k) + 1

  println(list.take(n).last)
}

object AnotherApproach extends App {

  val k = 6

  val node1 = ListNode(1, null)
  val node2 = ListNode(2, null)
  val node3 = ListNode(3, null)
  val node4 = ListNode(4, null)
  val node5 = ListNode(5, null)
  val node6 = ListNode(6, null)
  val node7 = ListNode(7, null)
  val node8 = ListNode(8, null)
  val node9 = ListNode(9, null)


  node1.next = node2
  node2.next = node3
  node3.next = node4
  node4.next = node5
  node5.next = node6
  node6.next = node7
  node7.next = node8
  node8.next = node9

  case class ListNode(data: Int, var next: ListNode)

  val i = node1
  val j = k - 1

  if (j < 0) {
    throw new RuntimeException("kth element cannot be negative")
  }

  val headNode = node1
  val positionNode = placePointer(node1, j)

  val result = recurseUntilYouReachWhereYouWantToBe(headNode, positionNode)

  println(result.data)

  @tailrec
  def placePointer(node: ListNode, position: Int): ListNode = {
    if (position == 0) {
      node
    }
    else if (node == null) {
      throw new RuntimeException("Nothing to traverse beyond this")
    }
    else {
      placePointer(node.next, position - 1)
    }
  }

  @tailrec
  def recurseUntilYouReachWhereYouWantToBe(start: ListNode, tail: ListNode): ListNode = {
    if (tail.next == null) {
      start
    }
    else {
      recurseUntilYouReachWhereYouWantToBe(start.next, tail.next)
    }
  }
}

object NextGreaterElementInArray extends App {

  val anArray = (1 to 100).toArray //

  //println(anArray.sorted.takeRight(2).head)

  val start = 0
  val end = anArray.length - 1

  println(quickSort(anArray, 0, end).toList)

  def quickSort(arr: Array[Int], start: Int, end: Int): Array[Int] = {
    if (start < end) {
      val partitionIndex = partition(arr, start, end)
      quickSort(arr, start, partitionIndex - 1)
      quickSort(arr, partitionIndex + 1, end)
    }
    else {
      arr
    }
  }

  def partition(array: Array[Int], start: Int, end: Int): Int = {
    val pivot = array(end)
    var pIndex = start

    for (i <- start until end) {
      if (array(i) >= pivot) {
        val temp = array(i)
        array(i) = array(pIndex)
        array(pIndex) = temp
        pIndex += 1
      }
    }
    val temp = array(pIndex)
    array(pIndex) = array(end)
    array(end) = temp

    pIndex
  }
}

object ArrayListUsingArrays extends App {

  val array = new Array[Int](50)

  println(insertElement((1 to 200).toList, array).toList)


  def insertElement(elementList:List[Int], array: Array[Int], start: Int = 0, capacity: Int = 50): Array[Int] = {
    if(elementList.isEmpty){
      array
    }
    else{
      try {
        insertElement(elementList.tail, array.updated(start, elementList.head), start + 1)
      }
      catch {
        case _: IndexOutOfBoundsException =>
          val newCapacity = capacity * 2
          val newArray = new Array[Int](newCapacity)
          array.copyToArray(newArray,0)
          insertElement(elementList, newArray, start, newCapacity)
      }
    }
  }
}