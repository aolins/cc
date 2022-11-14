package arrays1d

object maximisethesum extends App{

  //https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/maximize-sum-0423b95e/
  //one time limit exceeded

  val tests = scala.io.StdIn.readLine().toInt

  for (_ <- 1 to tests) {
    val params = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val amount = params(1)
    val array: Array[Long] = scala.io.StdIn.readLine().split(" ").map(_.toLong)

    val positive = array.filter( _ > 0 )

    val map:Map[Long, Array[Long]] = positive.sorted.groupBy(identity)

    val multiplied = map.keys.map( key => {val list = map(key); list.length * key}).toList

    val keys = multiplied.sorted.takeRight(amount).foldLeft(0l)( _ + _)

    println(keys)
  }

}
