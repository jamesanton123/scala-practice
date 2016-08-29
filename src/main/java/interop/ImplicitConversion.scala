package interop

import scala.language.implicitConversions

/**
 * Demonstrates the use of a type conversion which does not belong to the class
 */
object Example5 extends App { 
  implicit def intToString(x: Int) = x.toString + "test"
  
  // Because of this intToString implicit conversion method defined above, 
  // I am able to use String's toUpperCase method on an Int type
  println(1.toUpperCase())  
}
