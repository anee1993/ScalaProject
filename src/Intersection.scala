

object Intersection extends App {

  val array1 = Array(7,1,5,2,3,6)    //2,3,5,6,7
  val array2 = Array(3,8,6,20,7)  // 3,6,7,8,20

  val sortedArray1 = array1.sorted
  val sortedArray2 = array2.sorted

  val diff = sortedArray2.diff(sortedArray1)

  val union = sortedArray1 ++ diff

  println(union.mkString(","))

  val intersection = sortedArray2.diff(diff)

  println(intersection.mkString(","))
}
