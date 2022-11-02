object XorAnd extends App {


 val tests = scala.io.StdIn.readLine().toInt
//val tests = 1

  for (_ <- 1 to tests) {
    val length = scala.io.StdIn.readLine().toInt
    val arr = scala.io.StdIn.readLine().split(" ").map(_.toLong).toSet.toArray
    var min = Long.MaxValue
    if(arr.length < length){
      println(0)
    }else {
      for (i <- 0 to arr.length - 1) {
        for (j <- i + 1 to arr.length - 1) {
          val a: Long = arr(i)
          val b: Long = arr(j)
          val local = (a & b) ^ (a | b)
          if (local < min) {
            min = local
          }
        }
      }
      println(min)
    }

  }
}
