package leetcode.twonumbers

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object Solution {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val listBuffer = new ListBuffer[Int]

    val resultBuffer = loopAndAddToBuffer(listBuffer, l1)
    resultBuffer += -1
    val finalBuffer = loopAndAddToBuffer(resultBuffer, l2)

    println(finalBuffer.toString())
    val subLists = finalBuffer.splitAt(listBuffer.indexWhere(_ == -1))
    val list1 = subLists._1.reverse
    val list2 = subLists._2.tail.reverse

    println(list1)
    println(list2)

    val sum = {
      val diff = list1.size - list2.size
      if(diff < 0)
        addDigitByDigit(prependZeros(list1, diff.unary_-), list2)
      else
        addDigitByDigit(list1, prependZeros(list2, diff))
    }

    println(sum)

    println(sum.mkString("->"))
    val nodeElements = sum.map(x => new ListNode(x))
    linkTheNodes(nodeElements, 0, 1)
  }

  @tailrec
  def loopAndAddToBuffer(listBuffer: ListBuffer[Int], node: ListNode): ListBuffer[Int] = {
    if (node.x == -1) {
      listBuffer
    }
    else {
      listBuffer += node.x
      if (node.next == null) {
        loopAndAddToBuffer(listBuffer, new ListNode(-1))
      }
      else {
        loopAndAddToBuffer(listBuffer, node.next)
      }
    }
  }

  @tailrec
  def addDigitByDigit(numBuffer1: ListBuffer[Int], numBuffer2: ListBuffer[Int], carry: Int = 0, resultBuffer: ListBuffer[Int] = ListBuffer.empty[Int]): ListBuffer[Int] = {
    if (numBuffer1.nonEmpty) {
      val sum = numBuffer1.last + numBuffer2.last + carry
      if (sum >= 10) {
        val quotient = sum / 10
        val remainder = sum % 10
        addDigitByDigit(numBuffer1.take(numBuffer1.length-1), numBuffer2.take(numBuffer2.length-1), quotient, resultBuffer += remainder)
      }
      else {
        addDigitByDigit(numBuffer1.take(numBuffer1.length-1), numBuffer2.take(numBuffer1.length-1), 0, resultBuffer += sum)
      }
    }
    else {
      if(carry!=0) {
        resultBuffer += carry
      }
      else
        resultBuffer
    }
  }

  @tailrec
  def linkTheNodes(listNodes: ListBuffer[ListNode], start: Int, next: Int): ListNode = {
    if (next == listNodes.length) {
      listNodes.head
    }
    else {
      listNodes(start).next = listNodes(next)
      linkTheNodes(listNodes, start + 1, next + 1)
    }
  }

  @tailrec
  def prependZeros(listBuffer: ListBuffer[Int], times: Int): ListBuffer[Int] = {
    if(times == 0) {
      listBuffer
    }
    else {
      prependZeros(listBuffer.prepend(0), times -1)
    }
  }
}

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}