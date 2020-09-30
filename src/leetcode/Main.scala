package leetcode
import twonumbers.{ListNode, Solution}
object Main extends App {
  val listNode = new ListNode(2)
  val second = new ListNode(4)
  val third = new ListNode(3)

  listNode.next = second
  second.next = third

  val anotherListNode = new ListNode(5)
  val secondNode = new ListNode(6)
  val thirdNode = new ListNode(4)

  anotherListNode.next = secondNode
  secondNode.next = thirdNode

val sol = Solution.addTwoNumbers(listNode, anotherListNode)

  println(sol.x)
  println(sol.next.x)
  println(sol.next.next.x)
}
