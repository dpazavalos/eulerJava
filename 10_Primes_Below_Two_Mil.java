/**
 * Problem:
 *  The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *  Find the sum of all the primes below two million.
 *
 *  Solution:
 *   Implementation of Sieve of Eratosthenes
 */

class Eratosthenes {

  // "Find the sum of all primes below [TargetMax]"
  private final int TargetMax;
  // Array of all numbers 1::TargetMax. Numbers are assigned as parsed
  private int[] All;

  Eratosthenes(int targetMax) {
    TargetMax = targetMax;
    All = new int[TargetMax+1]; // +1 to start index on 0
  }
  // 0  : Unassigned
  // -1 : Non-Prime

  long findSum(){
    int i;          // Values in All
    int sieveCheck; // used to Mark multiples of i as non-prime
    long sum = 0;   // Final total, calculated while parsing

    // Set starting values
    All[0] = -1;  // Placeholder for 0
    All[1] = -1;  // Placeholder for 1
    All[2] = 2;

    for (i=2; i<=TargetMax; i++){
      if (All[i] == 0){
        // Value has not yet been assigned, and may still be prime
        All[i] = i;
      }

      if (All[i] == -1) {
        // Value was found to be a multiple of a prev entry, i.e. not a prime
        assert true;
      }
      else {
        // Value is Prime. Add to sum, remove multiples from consideration (mark as -1)
        sum += i;
        sieveCheck = i*2;
        while (sieveCheck<=TargetMax){
          All[sieveCheck] = -1; // Mark multiples of value as not prime
          sieveCheck += i;
        }
      }
    }
    return sum;
  }
}


public class Main {
  public static void main(String[] args) {
    Eratosthenes finder = new Eratosthenes(2_000_000);
    System.out.println(finder.findSum());
    // 142913828922
  }
}
