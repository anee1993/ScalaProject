import scala.annotation.tailrec

object BinaryTress extends App {

  val node = BinaryTreeNode(1,null,null,null)
  val node2 = BinaryTreeNode(2,null,null,null)
  val node3 = BinaryTreeNode(3,null,null,null)
  val node4 = BinaryTreeNode(4,null,null,null)
  val node5 = BinaryTreeNode(5,null,null,null)
  val node6 = BinaryTreeNode(6,null,null,null)
  val node7 = BinaryTreeNode(7,null,null,null)

  node.left = node2
  node.right = node3

  node2.left = node4
  node2.right = node5
  node2.parent = node

  node3.left = node6
  node3.right = node7
  node3.parent = node

  node4.parent = node2
  node5.parent = node2
  node6.parent = node3
  node7.parent = node3


  val root = node

  val leftMostLeafNode = findLeafNode(root)
  val rightSideLeftMostLeafNode = findLeafNode(root.right)

  println(s"LeftLeaf ${leftMostLeafNode.data}")
  println(s"RightLeaf ${rightSideLeftMostLeafNode.data}")

  case class BinaryTreeNode(data: Int, var left: BinaryTreeNode, var right: BinaryTreeNode, var parent: BinaryTreeNode)


  printInOrderTraversal(leftMostLeafNode)

  @tailrec
  def findLeafNode(node: BinaryTreeNode): BinaryTreeNode = {
    if(null == node.left){
      node
    }
    else {
      findLeafNode(node.left)
    }
  }

  def printInOrderTraversal(leftMost: BinaryTreeNode, pass: Int = 0): Unit = {
    if(pass == 2) {
      println("Done")
    }
    else {
      println(leftMost.data)
      println(leftMost.parent.data)
      if(leftMost.parent.parent != null) {
        println(leftMost.parent.right.data)
      } else {
        printInOrderTraversal(rightSideLeftMostLeafNode, pass + 1)
      }
      printInOrderTraversal(leftMost.parent)
    }
  }
}
