/**
 * Problem:
 *  A Pythagorean triplet is a set of three natural numbers, a < b < c, for which
 *  a^2 + b^2 = c^2
 *  3^2 + 4^2 = 9 + 16 = 25 = 5^2
 *  There exists exactly one Pythagorean triplet for which a + b + c = 1000
 *  Find the producct abc
 *
 * Solution:
 *  Iterate through natural number possibilities to create natural pythagorean triplets (ignoring
 *  any where c is non-natural i.e. float via thrown exception). (3, 4, 5) Check the sum of each
 *
 *  Origional implementation utilized Euclidian triplet geneartor, however while Euclid's foruma
 *  will always generate A pythag triplet, it will not generate EVERY possible triplet.
 *
 */

import java.lang.Math;

class PythagTripFinder {

  private final int FinalTarget = 1_000;

  // Math calls
  /**
   * Finds the sum of a given pythagorean triplet
   * @param pythagTrip array of int a, b, c
   * @return a+b+c
   */
  private int SumTriplet(int[] pythagTrip) {
    return pythagTrip[0] + pythagTrip[1] + pythagTrip[2];
  }
  /**
   * Finds the product of a given pythagorean triplet
   * This provides our answer
   * @param pythagTrip array of int a, b, c
   * @return abc
   */
  private int productTriplet(int[] pythagTrip) {
    return pythagTrip[0] * pythagTrip[1] * pythagTrip[2];
  }
  /**
   * Simple pythagorean triplet maker. Provided natural a and b, generate full array of [a, b, c]
   * ( a^2 + b^2 = c^2)
   * Raises ArithmeticException if c is non-natural
   * @param a Side a Length
   * @param b Side a Length
   * @return [a, b, c]
   */
  private int[] TripletMaker (int a, int b){
    int[] pythagTrip = new int[3];
    pythagTrip[0] = a;
    pythagTrip[1] = b;
    double c = Math.sqrt((a*a)+(b*b));
    if (!(c%1==0)) {
      throw new ArithmeticException("Natural numbers only! Generated C is non natural");
    }
    pythagTrip[2] = (int) c;
    return pythagTrip;
  }

  /**
   * Returns the pythagorean triplet that sums to FinalTarget, and prints the product of the triplet
   */
  void FindTripletProduct(){
    int a= 3;
    int b;
    int pythagSum;
    int[] pythagTrip = new int[3];
    int finalSum = 0;

    while (finalSum==0) {
      b = a + 1;
      pythagSum = 0;

      while (pythagSum < FinalTarget) {
        try{
          pythagTrip = TripletMaker(a, b);
          pythagSum = SumTriplet(pythagTrip);
          if (pythagSum==FinalTarget){
            // Final Target found
            finalSum = pythagSum;
            break;
          }
        }
          catch (ArithmeticException ae){
          assert true;
        }
        b += 1;
      }

      a += 1;
    }

    // Elementes of triplet
    for (int x : pythagTrip) {
      System.out.print(x + " ");
    }
    // Sum
    System.out.println(" = " + finalSum);
    // Product
    System.out.println(productTriplet(pythagTrip));
  }
}


public class Main {
  public static void main(String[] args) {
    PythagTripFinder finder = new PythagTripFinder();
    finder.FindTripletProduct();
    // 31875000
  }
}
