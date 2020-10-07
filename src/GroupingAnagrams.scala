import scala.annotation.tailrec
import scala.collection.mutable

object GroupingAnagrams extends App {

  val arr = Array("god","dog","run","fun","teacher","cheater","eefee","feeef")

  val anagramIdentifierQueue = new mutable.Queue[Char]()

  identifyAnagramsFor(arr.head, arr.tail)
  @tailrec
  def identifyAnagramsFor(word: String, otherWords: Array[String]): Unit = {
    if(otherWords.isEmpty){
      println("All words have been checked")
    }
    else {
      otherWords.foreach(
        eachWordInList => {
          if (areTheGivenWordsAnagrams(word, eachWordInList)) {
            println(s"Words $word and $eachWordInList are Anagrams")
          }
        }
      )
      identifyAnagramsFor(otherWords.head, otherWords.tail)
    }
  }

  def areTheGivenWordsAnagrams(givenWord: String, wordToCheck: String): Boolean = {
    anagramIdentifierQueue.clear()
    if(givenWord.length != wordToCheck.length){
      return false
    }
    anagramIdentifierQueue.addAll(givenWord.toCharArray)
    wordToCheck.foreach(char => {
      if(anagramIdentifierQueue.contains(char)){
        anagramIdentifierQueue.removeFirst(_ == char)
      }
    })
    anagramIdentifierQueue.isEmpty
  }
}
