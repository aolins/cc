object thirteen extends App {

  ///https://www.youtube.com/watch?v=HFGZ1-y-1No&list=PL1YS4hYJip07A-YteNUR8qTeA_wHQarDX&index=47
  val tests = scala.io.StdIn.readLine().toInt
  //val tests = 1

  val modulo = 1000000009L

  var cache = collection.mutable.HashMap[Long, Long]((0l, 1l), (1L, 10L), (2l, 99l), (3l, 980l), (4, 9701l))

  def recur(length:Long):Long = {
    if (cache.contains(length)){
      cache(length)
    }else{
      if(length % 2 == 0){
        val shorterHalves = recur(length/2 - 1)
        val halves = recur(length/2)
        val value = halves*halves % modulo - shorterHalves*shorterHalves % modulo
        cache += ((length, value))
        value
      }else if (length % 3 == 0){
        val thirds:Long = recur(length/3)
        val shorterThirds:Long = recur(length/3-1)
        val value = (thirds*thirds % modulo)*thirds % modulo - (shorterThirds*shorterThirds % modulo) * shorterThirds % modulo
        cache += ((length, value))
        value
       }else{
        0l
      }
    }
  }



  for (_ <- 1 to tests) {
    val length = scala.io.StdIn.readLine().toLong

    if (cache.contains(length)){
      println(cache(length))
    }else{

    }

  }

}
