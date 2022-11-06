package arrays1d

//object oneDsum extends App {
//
//  //  {
//  //    val array = "1 2 2 3 3 3 4 4 4 4 5 5 5 5 5".split(" ").map(_.toLong)
//  //
//  //    val sorted = array.groupBy(identity).toList.sortWith((a,b)=> (a._2.length < b._2.length))
//  //
//  //    println(sorted)
//  //
//  //    println(sorted.dropWhile(x => x._2.length <2))
//  //
//  //    println(sorted.dropWhile(x => x._2.length <2).reverse.dropWhile(x => x._2.length >4))
//  //  }
//
//
//  //https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/minor-4-41918cb8/
//  val length = scala.io.StdIn.readLine().toLong
//  val array = scala.io.StdIn.readLine().split(" ").map(_.toLong)
//  val sorted = array.groupBy(identity).toList.sortWith((a, b) => (a._2.length < b._2.length))
//  val cleansed: List[(Long, Int)] = sorted.map(x => (x._1 * x._2.length, x._2.length))
//  val groups:List[(Int, List[(Long,Int)])] = cleansed.groupBy(x => x._2).toList
//  val sums = groups.map( x => (x._2.foldRight(0l)((el,ac)=> ac + el._1*el._2 ), x._1)).sortWith((a, b) => a._2 < b._2)
//  val min = cleansed(0)._2
//  val max = cleansed.last._2
//  val tests = scala.io.StdIn.readLine().toLong
//  //var cache = collection.mutable.HashMap[(Int, Int), Long](((0, 0), 0l))
//
//  for (_ <- 1l to tests) {
//    val params = scala.io.StdIn.readLine().split(" ").map(_.toInt)
//    val freqFrom = params(0)
//    val freqTo = params(1)
////    if (cache.contains((freqFrom, freqTo))) {
////      println(cache(freqFrom,freqTo))
////    } else {
//
//      if (freqFrom > max || freqTo < min) {
////        cache += (((freqFrom,freqTo), 0L))
//        println(0)
//      } else {
//
//        val droppedFrom = sums.dropWhile(x => x._2 < freqFrom)
//        val trimmed = droppedFrom.reverse.dropWhile(x => x._2 > freqTo)
//
//        val res = trimmed.foldRight(0l)((x, accum) => accum + x._1)
//
////        cache += (((freqFrom,freqTo), res))
//        println(res)
//      }
////    }
//  }
//}

object oneDsum extends App {

  val long = System.currentTimeMillis()


  //https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/minor-4-41918cb8/
  val length = scala.io.StdIn.readLine().toLong
  val array = scala.io.StdIn.readLine().split(" ").map(_.toLong)
  //  println("read "+(System.currentTimeMillis() - long))
  //  val grouped = array.groupBy(identity)
  //  println("grouped " +(System.currentTimeMillis() - long))
  //
  //
  //
  //  val listed = grouped.toList
  //  println("listed  " + (System.currentTimeMillis() - long))
  //    val sorted = listed.sortWith((a, b) => (a._2.length < b._2.length))
  //  println("sortred " +(System.currentTimeMillis() - long))
  //  val cleansed: List[(Long, Int)] = sorted.map(x => (x._1 * x._2.length, x._2.length))
  //  println("cleansed " +( System.currentTimeMillis() - long))
  //  val min = cleansed(0)._2
  //  val max = cleansed.last._2

  //
  //  val acc: List[(Long, Int)] = List()
  //  val summed = cleansed.foldLeft(List(): List[(Long, Int)])((accum, y) => {
  //    if (accum.isEmpty) {
  //      List(y)
  //    } else {
  //      val head = accum.head
  //      if (head._2 != y._2) {
  //        y :: accum
  //      } else {
  //        (head._1 + y._1, head._2) :: accum.tail
  //      }
  //    }
  //  }).reverse
  //  val summedMapped:Array[Long] = summed.map(_._1).toArray
  //  println("summed  " + (System.currentTimeMillis() - long))

  val constructed = array.foldLeft(scala.collection.mutable.HashMap(): scala.collection.mutable.HashMap[Long, Int])((acc, x) => {

    if (acc.contains(x)) {
      val count = acc(x)
      acc.update(x, count + 1)
    } else {
      acc.put(x, 1)
    }
    acc

  })
  //  println("grouped2 " +(System.currentTimeMillis() - long))

  val inverted = constructed.foldLeft(scala.collection.mutable.HashMap(): scala.collection.mutable.HashMap[Int, Long])((acc, x) => {
    if (acc.contains(x._2)) {
      val count = acc(x._2)
      acc.update(x._2, count + x._2 * x._1)
    } else {
      acc.put(x._2, x._2 * x._1)
    }
    acc
  }
  )
  //  println ("cleansed " + (System.currentTimeMillis() - long))

  val sorted2 = inverted.toList.sortWith((a, b) => (a._1 < b._1))

  //  println(inverted)
  //  println(sorted2)

  //val summedMapped:Array[Long] = sorted2.map(_._2).toArray
  //  println("summed  " + (System.currentTimeMillis() - long))

  val min = sorted2.head._1
  val max = sorted2.last._1


  //  println(System.currentTimeMillis() - long)
//    println(sorted2)

  val summedMapped: Array[Long] = sorted2.map(_._2).toArray



  //    println("summed  " + (System.currentTimeMillis() - long))

  def s(ix:Int) = if (ix > summedMapped.length - 1) 0l else summedMapped(ix)
  val cache = Map(
    (1, 1) -> (s(0)),
    (1, 2) -> (s(0) + s(1)),
    (1, 3) -> (s(0) + s(1) + s(2)),
    (1, 4) -> (s(0) + s(1) + s(2) + s(3)),
    (1, 5) -> (s(0) + s(1) + s(2) + s(3) + s(4)),
    (1, 6) -> (s(0) + s(1) + s(2) + s(3) + s(4) + s(5)),
    (1, 7) -> (s(0) + s(1) + s(2) + s(3) + s(4) + s(5) + s(6)),
    (1, 8) -> (s(0) + s(1) + s(2) + s(3) + s(4) + s(5) + s(6) + s(7)),
    (2, 2) -> (s(1)),
    (2, 3) -> (s(1) + s(2)),
    (2, 4) -> (s(1) + s(2) + s(3)),
    (2, 5) -> (s(1) + s(2) + s(3) + s(4)),
    (2, 6) -> (s(1) + s(2) + s(3) + s(4) + s(5)),
    (2, 7) -> (s(1) + s(2) + s(3) + s(4) + s(5) + s(6)),
    (2, 8) -> (s(1) + s(2) + s(3) + s(4) + s(5) + s(6) + s(7)),
    (3, 3) -> (s(2)),
    (3, 4) -> (s(2) + s(3)),
    (3, 5) -> (s(2) + s(3) + s(4)),
    (3, 6) -> (s(2) + s(3) + s(4) + s(5)),
    (3, 7) -> (s(2) + s(3) + s(4) + s(5) + s(6)),
    (3, 8) -> (s(2) + s(3) + s(4) + s(5) + s(6) + s(7)),
    (4, 4) -> (s(3)),
    (4, 5) -> (s(3) + s(4)),
    (4, 6) -> (s(3) + s(4) + s(5)),
    (4, 7) -> (s(3) + s(4) + s(5) + s(6)),
    (4, 8) -> (s(3) + s(4) + s(5) + s(6) + s(7)),
    (5, 5) -> (s(4)),
    (5, 6) -> (s(4) + s(5)),
    (5, 7) -> (s(4) + s(5) + s(6)),
    (5, 8) -> (s(4) + s(5) + s(6) + s(7)),
    (6, 6) -> (s(5)),
    (6, 7) -> (s(5) + s(6)),
    (6, 8) -> (s(5) + s(6) + s(7)),
    (7, 7) -> (s(6)),
    (7, 8) -> (s(6) + s(7)),
    (8, 8) -> (s(7))

  )

  val tests = scala.io.StdIn.readLine().toLong

  for (_ <- 1l to tests) {
    val params = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val freqFrom = params(0)
    val freqTo = params(1)

    if (freqFrom > max || freqTo < min) {
      println(0)
    } else {

      var res: Long = 0l

      if (cache.contains((freqFrom, Math.min(freqTo, summedMapped.length)))) {
        res = cache((freqFrom, Math.min(freqTo, summedMapped.length)))
      } else {
        for (i <- freqFrom - 1 to Math.min(freqTo, summedMapped.length) - 1) {
          println("xx")
          res = res + summedMapped(i)
        }

      }
      //
      //      for( i <- freqFrom-1 to Math.min(freqTo-1, summedMapped.length-1)){
      //
      //        res = res + summedMapped(i)
      //      }
      //      val droppedFrom = sorted2.dropWhile(x => x._1 < freqFrom)
      //      val trimmed = droppedFrom.reverse.dropWhile(x => x._1 > freqTo)
      //
      //      val res = trimmed.foldRight(0l)((x, accum) => accum + x._2)

      println(res)
    }
  }
}


