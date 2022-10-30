/*
// Sample code to perform I/O:

val name = scala.io.StdIn.readLine()        // Reading input from STDIN
println("Hi, " + name + ".")                // Writing output to STDOUT

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
*/

//https://www.hackerearth.com/practice/codemonk/

// Write your code here
object cycleShift extends App{
  val tests = scala.io.StdIn.readLine().toInt

  def recur(A:String, previousState:String, K:Int):Int = {
    //println( s"params: A=$A, prev=$previousState, K=$K")
    if (previousState == A && K==1){
      0
    }else{
      val shifted = previousState.substring(1) + previousState.charAt(0)
      1 + recur(A, shifted, if (previousState == A) K-1 else K)
    }
  }

  def bigger (x:String,max:String):Boolean={
    var big = false
    var finished = false
    for (ix <- 0 to x.length-1){
      if (!finished){
        if(x.charAt(ix) > max.charAt(ix)){
          big = true
          finished = true
        }else if (x.charAt(ix) < max.charAt(ix)){
          finished = true
        }
      }
    }
    big
  }


  for (_ <- 1 to tests){
    val params = scala.io.StdIn.readLine().split(" ").map(_.toLong)
    val N = params(0)
    var K = params(1)
    val A = scala.io.StdIn.readLine()

    var B = A
    var i = A
    var shiftsToB = 0l
    var shifted = ""

    for (cyclicShifts <- 1l to N ){
      shifted = i.substring(1) + i.charAt(0)
      if (bigger(shifted, B)){
        B = shifted
        shiftsToB = cyclicShifts
      }
      i = shifted
    }



    /*
    var count = shiftsToB


    var cc = 1l
    K = K - 1

    shifted = B.substring(1) + B.charAt(0)
    while(K>0){
        if(shifted == B){
            count = count*K
            K=0
        }else{
            shifted = shifted.substring(1) + shifted.charAt(0)
            count = count+1
        }
    }
    */


    var steps = 0L
    var shiftingString = A

    var firstEncounter = false
    var secondEncounter = false

    var initSteps = 0l
    var goingSteps = 0l
    while (K>0){
      if (B == shiftingString){
        K = K - 1

        if (!secondEncounter && firstEncounter){
          secondEncounter =  true
          goingSteps = steps - initSteps
          K = 0
        }
        if (!firstEncounter){
          firstEncounter = true
          initSteps = steps
        }

      }

      if (K > 0){
        shiftingString = shiftingString.substring(1) + shiftingString.charAt(0)
        steps = steps + 1
      }
    }

    K = params(1)
    steps = initSteps + goingSteps*(K-1)




    println(steps)
  }
}