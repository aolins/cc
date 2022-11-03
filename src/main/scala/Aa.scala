
//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/howie-and-the-menus-2-48359fe4/
object Aa extends App {

  val params = scala.io.StdIn.readLine().split(" ")
  val menus = params(0).toInt
  val items = params(1).toInt
  val allMenus = (for (i <- 1 to menus) yield scala.io.StdIn.readLine().split(" ").toList.map(_.toLong)).toList

  def process(allMenus: List[List[Long]]): Long = {
    val b = List.fill(allMenus.length)(0L)
    val s = List.fill(allMenus.length)(0L)
    processRecur(allMenus, s,b )
  }

  def processResults(param:(List[Long], List[Long])): Long ={
    val (sum,biggest) = param
    val max = biggest.foldRight(-1L)((x, max)=> if (x > max) x else max)
    val interim = biggest.zip(sum).zipWithIndex


    val biggestTuples = interim.filter( biggest => biggest._1._1 == max)

    if (biggestTuples.length == 1){
       biggestTuples(0)._2 + 1
    } else {

      val maxSum = biggestTuples.foldRight(-1L)((x, max) => if (x._1._2 > max) x._1._2 else max)
      val biggestTuplesWithMaxSum = biggestTuples.filter(b => b._1._2 == maxSum)
      biggestTuplesWithMaxSum(0)._2 + 1
    }
  }

  def processRecur(param:(List[List[Long]], List[Long], List[Long])): Long ={
    val (menus,sum,biggest) = param

    if (menus(0).isEmpty){
      processResults(sum,biggest)
    }else{
      val heads = for(x <- menus) yield x.head
      val maxItem = heads.foldRight(-1L)((x, max)=> if (x > max) x else max)

      val zippedHeads = heads.zipWithIndex
      val biggestHeads = zippedHeads.filter(x => x._1 == maxItem)

      val (_, biggestIxes) = biggestHeads.unzip

      val biggestZipped = biggest.zipWithIndex

      val modifiedBiggests = biggestZipped.map(x => if (biggestIxes.contains(x._2)) x._1 + 1 else x._1)

      val sumAndHeads = sum.zip(heads)

      val modifiedSums = sumAndHeads.map( x => x._2+x._1)

      val tails = for(x <- menus) yield x.tail
      processRecur(tails, modifiedSums, modifiedBiggests)
    }
  }

  println(process(allMenus))

}

object X extends App {
  import Aa._
  println(process(List(

    List(3, 2, 3, 4),
    List(1, 2, 1, 10),
    List(1, 3, 3, 2)
  )))


}

object pr extends App{

  val l = 500000009l
  println(l.toBinaryString)
  val k = Math.pow(2, l.toBinaryString.length-1).toLong
  println( k )
  println( k.toBinaryString )
  println( l - k )

}