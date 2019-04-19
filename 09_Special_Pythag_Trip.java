/**
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
   * Returns the pythagorean triplet that sums to 1000, and returns the product of that triplet
   * @return
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


    for (int x : pythagTrip) {
      System.out.print(x + " ");
    }
    System.out.println(" = " + finalSum);
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
