package arrays1d

object  nondecreasing extends App {

  val long = System.currentTimeMillis()

  //https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/make-it-non-decreasing-7d3391fd/
  val tests = scala.io.StdIn.readLine().toInt

  for (_ <- 1 to tests) {
    val length = scala.io.StdIn.readLine().toInt
    var array:Array[Long] = scala.io.StdIn.readLine().split(" ").map(_.toLong)

    for (ix <- 1 until length){
      val previous = array(ix - 1)
      val current = array(ix)

      if (current < previous){
        val multiplicator = previous / current
        val newCurrent = current * multiplicator
        if (newCurrent >= previous){
          array(ix) = newCurrent
        }else{
          array(ix) = newCurrent + current
        }

      }
    }
    println(array.mkString(" "))
  }
}