package interop

/**
 * Demonstrates calling a java method from scala
 */
object Example1 extends App {
  val list = java.util.Arrays.asList("test3", "test2", "test4", "test1")
  java.util.Collections.sort(list)  
  println(list)
}

/**
 * Demonstrates accessing java fields
 */
object Example2 extends App {
  val point = new java.awt.Point
  point.x = 5
  point.y = 7
  
  println(point.x + " " + point.y)
}

/**
 * Demonstrates inheritance from java classes
 */
object Example3 extends App {  
  class PrintSizeArrayList[String] extends java.util.ArrayList[String]{
    override
    def size(): Int = {
      println("the size is: " + super.size())
      return super.size()
    }
  }  
  var list = new PrintSizeArrayList[String]
  list.add("test")
  list.size()  
}

/**
 * Demonstrates implementation of java interfaces
 */
object Example4 extends App {
  class BigIntegerWrapper(wrappedBigInteger: java.math.BigInteger) extends Comparable[BigIntegerWrapper]{
    def getWrappedBigInteger : java.math.BigInteger = {
      return wrappedBigInteger
    }    
    override
    def compareTo(x: BigIntegerWrapper): Int = {
      return this.getWrappedBigInteger.compareTo(x.getWrappedBigInteger)
    }
  }
  
  val one = new BigIntegerWrapper(java.math.BigInteger.ONE)
  val ten = new BigIntegerWrapper(java.math.BigInteger.TEN)
  val anotherOne = new BigIntegerWrapper(java.math.BigInteger.ONE)
  
  println(one.compareTo(one))        // 0
  println(one.compareTo(ten))        // -1
  println(ten.compareTo(one))        // 1
  println(one.compareTo(anotherOne)) // 0
  
  
}