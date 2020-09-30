import scala.annotation.tailrec

object RotateAnArray extends App {

  val anArray = Array[Int](1,2,3,4,5,6,7,8)
  val rotateBy = 2

  //faster but space consuming apporach.
  val rotatedArray = anArray.takeRight(anArray.length-rotateBy) ++ anArray.take(rotateBy)

  //slower but operated on a single array with in-place rotation
  val traditionallyRotatedArray = traditionalRotate(anArray, rotateBy)

  println(rotatedArray.mkString(","))

  println(traditionallyRotatedArray.mkString(","))

  @tailrec
  def traditionalRotate(inputArray: Array[Int], rotateBy: Int): Array[Int] = {
    if(rotateBy == 0)
      inputArray
    else{
      traditionalRotate(rotate(inputArray,0,inputArray.length -1), rotateBy - 1)
    }
  }

  @tailrec
  def rotate(arr: Array[Int], start: Int, len: Int): Array[Int] = {
    if(len == 0){
      arr
    }
    else {
      val temp = arr(start)
      arr(start) = arr(start+1)
      arr(start+1) = temp
      rotate(arr,start+1,len-1)
    }
  }
}
