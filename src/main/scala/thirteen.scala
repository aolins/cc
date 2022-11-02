object thirteen extends App{
  ///https://www.youtube.com/watch?v=HFGZ1-y-1No&list=PL1YS4hYJip07A-YteNUR8qTeA_wHQarDX&index=47
// val tests = scala.io.StdIn.readLine().toInt
  //  //val tests = 1
  //
  //  for (_ <- 1 to tests) {
  //    val length = scala.io.StdIn.readLine().toLong
  //  }

  var x = 0
  for (i <- 0 to 9999){
    if (i.toString.contains("13")){
      x=x+1
      println(i)
    }
  }
  println(10000-x)
}
