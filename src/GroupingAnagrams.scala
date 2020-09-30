import scala.annotation.tailrec

object GroupingAnagrams extends App {

  val arr = Array("", "b")

  println(groupAnagrams(arr))

  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    consolidateAnagramLists(strs.toList)
  }

  @tailrec
  def consolidateAnagramLists(inputList: List[String], resultant: List[List[String]] = List()): List[List[String]] = {
    if(inputList.isEmpty){
      resultant
    }
    else{
      val anagramsList = getAnagramList(inputList.head, inputList.tail) :+ inputList.head
        val remaining = inputList.diff(anagramsList)
        consolidateAnagramLists(remaining, resultant :+ anagramsList)
    }
  }
  @tailrec
  def getAnagramList(mainString: String, list: List[String], result: List[String] = List()): List[String] = {
    if(list.isEmpty)
      result
    else {
      val head = list.head
      if(mainString.length == head.length && mainString.toCharArray.forall(head.toCharArray.contains)){
        getAnagramList(mainString, list.tail, result :+ head)
      }
      else {
        getAnagramList(mainString, list.tail, result)
      }
    }
  }
}
