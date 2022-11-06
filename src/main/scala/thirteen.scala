object thirteen extends App {

  ///https://www.youtube.com/watch?v=HFGZ1-y-1No&list=PL1YS4hYJip07A-YteNUR8qTeA_wHQarDX&index=47
  val tests = scala.io.StdIn.readLine().toInt
  //val tests = 1

  val modulo = 1000000009L

  var cache = collection.mutable.HashMap[Long, Long]((0l, 1l), (1L, 10L), (2l, 99l), (3l, 980l), (4, 9701l))

  var cache2 = collection.mutable.HashMap[Long, Long]()

  def recur(length: Long): Long = {

    val c = if (length < modulo / 2) cache  else cache2
    if (c.contains(length)) {
      c(length)
    } else {




      if (length % 2 == 0) {
        val shorterHalves = recur(length / 2 - 1)
        val halves = recur(length / 2)
        var value = ((halves * halves)  - (shorterHalves * shorterHalves) ) % modulo
        if (value < 0) value = modulo + value
        c += ((length, value))
        value
      } else {


        val halfLength = length / 2
        val otherHalfLength = length - length / 2
        val half = recur(halfLength)
        val otherHalf = recur(otherHalfLength)
        val shorter = recur(halfLength - 1)
        var value = (half * ((otherHalf - shorter) )) % modulo

        if (value < 0) value = modulo + value
        c += ((length, value))
        value

        /*


//        println(length.toBinaryString)
//        val powerOfTwo = Math.pow(2, length.toBinaryString.length-1).toLong
//        var remainder = length - powerOfTwo
//        val longest = recur(powerOfTwo)
//        val short = recur(remainder)
//        val long = recur(powerOfTwo-1)
//        val shortes = recur(remainder-1)



        //        val halfLength = length / 2
        //        val otherHalfLength = length - length / 2
        //        val half = recur(halfLength)
        //        val otherHalf = recur(otherHalfLength)
        //        val shorter = recur(halfLength - 1)
        var value =(longest*short -  shortes*long) % modulo

        if (value < 0) value = modulo + value
        c += ((length, value))
        value
         */

      }
    }
  }


  for (_ <- 1 to tests) {
    val length = scala.io.StdIn.readLine().toLong

    if (cache.contains(length)) {
      println(cache(length))
    } else {
      println(recur(length))
    }
  }

}
