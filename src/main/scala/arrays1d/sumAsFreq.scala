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

  def s(ix: Int) = if (ix > summedMapped.length - 1) 0l else summedMapped(ix)

  val cache11 = (s(0))
  val cache12 = (s(0) + s(1))
  val cache13 = (s(0) + s(1) + s(2))
  val cache14 = (s(0) + s(1) + s(2) + s(3))
  val cache15 = (s(0) + s(1) + s(2) + s(3) + s(4))
  val cache16 = (s(0) + s(1) + s(2) + s(3) + s(4) + s(5))
  val cache17 = (s(0) + s(1) + s(2) + s(3) + s(4) + s(5) + s(6))
  val cache18 = (s(0) + s(1) + s(2) + s(3) + s(4) + s(5) + s(6) + s(7))
  val cache22 = (s(1))
  val cache23 = (s(1) + s(2))
  val cache24 = (s(1) + s(2) + s(3))
  val cache25 = (s(1) + s(2) + s(3) + s(4))
  val cache26 = (s(1) + s(2) + s(3) + s(4) + s(5))
  val cache27 = (s(1) + s(2) + s(3) + s(4) + s(5) + s(6))
  val cache28 = (s(1) + s(2) + s(3) + s(4) + s(5) + s(6) + s(7))
  val cache33 = (s(2))
  val cache34 = (s(2) + s(3))
  val cache35 = (s(2) + s(3) + s(4))
  val cache36 = (s(2) + s(3) + s(4) + s(5))
  val cache37 = (s(2) + s(3) + s(4) + s(5) + s(6))
  val cache38 = (s(2) + s(3) + s(4) + s(5) + s(6) + s(7))
  val cache44 = (s(3))
  val cache45 = (s(3) + s(4))
  val cache46 = (s(3) + s(4) + s(5))
  val cache47 = (s(3) + s(4) + s(5) + s(6))
  val cache48 = (s(3) + s(4) + s(5) + s(6) + s(7))
  val cache55 = (s(4))
  val cache56 = (s(4) + s(5))
  val cache57 = (s(4) + s(5) + s(6))
  val cache58 = (s(4) + s(5) + s(6) + s(7))
  val cache66 = (s(5))
  val cache67 = (s(5) + s(6))
  val cache68 = (s(5) + s(6) + s(7))
  val cache77 = (s(6))
  val cache78 = (s(6) + s(7))
  val cache88 = (s(7))


  val tests = scala.io.StdIn.readLine().toLong

  for (_ <- 1l to tests) {
    val params = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val freqFrom = params(0)
    val freqTo = params(1)

    if (freqFrom > max || freqTo < min) {
      println(0)
    } else {

      var res: Long = 0l

      val fr = freqFrom
      val to = Math.min(freqTo, summedMapped.length)

      if (fr == 1 && to == 1) res = cache11
      else if (fr == 1 && to == 2) res = cache12
      else if (fr == 1 && to == 3) res = cache13
      else if (fr == 1 && to == 4) res = cache14
      else if (fr == 1 && to == 5) res = cache15
      else if (fr == 1 && to == 6) res = cache16
      else if (fr == 1 && to == 7) res = cache17
      else if (fr == 1 && to == 8) res = cache18

      else if (fr == 2 && to == 2) res = cache22
      else if (fr == 2 && to == 3) res = cache23
      else if (fr == 2 && to == 4) res = cache24
      else if (fr == 2 && to == 5) res = cache25
      else if (fr == 2 && to == 6) res = cache26
      else if (fr == 2 && to == 7) res = cache27
      else if (fr == 2 && to == 8) res = cache28

      else if (fr == 3 && to == 3) res = cache33
      else if (fr == 3 && to == 4) res = cache34
      else if (fr == 3 && to == 5) res = cache35
      else if (fr == 3 && to == 6) res = cache36
      else if (fr == 3 && to == 7) res = cache37
      else if (fr == 3 && to == 8) res = cache38

      else if (fr == 4 && to == 4) res = cache44
      else if (fr == 4 && to == 5) res = cache45
      else if (fr == 4 && to == 6) res = cache46
      else if (fr == 4 && to == 7) res = cache47
      else if (fr == 4 && to == 8) res = cache48

      else if (fr == 5 && to == 5) res = cache55
      else if (fr == 5 && to == 6) res = cache56
      else if (fr == 5 && to == 7) res = cache57
      else if (fr == 5 && to == 8) res = cache58

      else if (fr == 6 && to == 6) res = cache66
      else if (fr == 6 && to == 7) res = cache67
      else if (fr == 6 && to == 8) res = cache68

      else if (fr == 7 && to == 7) res = cache77
      else if (fr == 7 && to == 8) res = cache78

      else if (fr == 8 && to == 8) res = cache88

      else {
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


