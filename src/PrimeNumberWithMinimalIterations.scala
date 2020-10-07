import scala.annotation.tailrec

object PrimeNumberWithMinimalIterations extends App {
  val number = 93
  val maxIterations = number / 2

  println(findIfPrime(number,maxIterations))

  @tailrec
  def findIfPrime(number: Int, maxIterations: Int, start: Int = 2): Boolean = {
    if(maxIterations == 0){
      return true
    }
    if(number % start == 0)
      false
    else {
      if((start + 1) % 2 == 0){
      findIfPrime(number, maxIterations - 1, start + 2)
      }
      else {
        findIfPrime(number, maxIterations - 1, start + 1)
      }
    }
  }
}
