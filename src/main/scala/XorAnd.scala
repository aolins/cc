object XorAnd extends App {


 //https://www.hackerearth.com/practice/codemonk/ Minimum AND xor OR
//maximum points
  val tests = scala.io.StdIn.readLine().toInt
  //val tests = 1

  for (_ <- 1 to tests) {
    val length = scala.io.StdIn.readLine().toInt
    val arr = scala.io.StdIn.readLine().split(" ").map(_.toLong).toSet.toArray.sorted
    var min = Long.MaxValue
    if(arr.length < length){
      println(0)
    }else {
      for (i <- 0 to arr.length - 2) {
        //        for (j <- i + 1 to arr.length - 1) {
        val a: Long = arr(i)
        val b: Long = arr(i+1)
        val local = (a & b) ^ (a | b)
        if (local < min) {
          min = local
        }
        // }
      }
      println(min)
    }

  }
}
