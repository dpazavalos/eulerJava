/**
 *
 */

import java.util.ArrayList;
import java.lang.Long;

class PythagTripFinder {

  // Prime numbers
  // private ArrayList<Long> FOUNDPRIMES = new ArrayList<Long>();

  // Pythagorean triplet where sum=1000
  int[] pythagTrip = new int[3];

  // working boolean
  boolean working = true;

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
   * Implementation of Euclid's formula to generate and return pythagorean triples. Provide m and n
   * https://en.wikipedia.org/wiki/Pythagorean_triple#Generating_a_triple
   *
   * @return Integer[3] of a, b, anc c for a
   */
  private int[] EuclidFormula (int m, int n){
    int[] pythagTrip = new int[3];
    pythagTrip[0] = (m*m)-(n*n);  // a
    pythagTrip[1] = 2*(m*n);      // b
    pythagTrip[2] = (m*m)+(n*n);  // c
    return pythagTrip;
  }

  /**
   * Iterates through possible m and n pairs to find the target triplet that sums to 1000
   * Threaded worker. Start one on even and one on odd numbers
   */
  class MNIterator extends Thread{
    void run(int mStart) {
      int m= mStart,
          pythagSum=0;
      int[] pythagTrip = new int[3];
      while (pythagSum<1000) {
        int n = m+1;
        pythagTrip = EuclidFormula(m, n);
        pythagSum = SumTriplet()

        m += 2;
      }
    }
  }

  /**
   * Returns the pythagorean triplet that sums to 1000, and returns the product of that triplet
   * @return
   */
  private int[] FindTripletProduct(){
    int[] mstarts = new int[2];
    mstarts[0] = 2;
    mstarts[0] = 3;
    for (int m : mstarts){
      MNIterator iterfind = new MNIterator();
      iterfind.run(m);
    }
    while (true) {
      MNIterator iterfind = new MNIterator();
      iterfind.run();
    }
    ;
  }

}


public class Main {
  public static void main(String[] args) {
    PrimeFinder finder = new PrimeFinder();
    System.out.println(finder.FindAPrime());
    // 104743
  }
}
