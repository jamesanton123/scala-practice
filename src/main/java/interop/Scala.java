package interop;

public class Scala {
	/**
	 * Demonstrating the use of a scala class from java code
	 * @param args
	 */
	public static void main(String[] args){
		BigIntegerWrapper scalaObject1 = new BigIntegerWrapper(java.math.BigInteger.ONE);
		BigIntegerWrapper scalaObject10 = new BigIntegerWrapper(java.math.BigInteger.TEN);
		System.out.println(scalaObject1.compareTo(scalaObject10));
	}
}
