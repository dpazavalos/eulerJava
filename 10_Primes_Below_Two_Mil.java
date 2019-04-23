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
  private final int TargetMax = 2_000_000;
  // private final int TargetMax = 1_000_000;

  // Array of all numbers 1::TargetMax
  // Numbers are assigned as parsed
  private int[] All = new int[TargetMax+1]; // +1 to start index on 0
  // 0  : Unassigned
  // -1 : Non-Prime

  void BuildAll(){
    int i;    // Values in All
    int val;
    int sieveCheck; //

    // Set starting values
    All[0] = -1;  // Placeholder for 0
    All[1] = -1;  // Placeholder for 1
    All[2] = 2;

    for (i=2; i<=TargetMax; i++){
      // System.out.println("i = " + i);

      // Assign entry value, if still 0
      if (All[i] == 0){
        // System.out.println("  Built " + i);
        All[i] = i;
      }
      val = All[i];
      if (val == -1) {
        assert true;
        // System.out.println("  " + i + " Is a known multiple");
      }
      else {
        sieveCheck = i*2;
        while (sieveCheck<=TargetMax){
          // Mark multiples of this value as -1 (Not Prime)
          // AllChecker(sieveCheck); // Ensure is built
          // System.out.print(sieveCheck + " ");
          // System.out.println(All[sieveCheck]);
          All[sieveCheck] = -1; // Mark multiples of value as not prime
          sieveCheck += i;
        }
      }
    }

    long sum = 0;
    for (int x : All) {
      if (x != -1){
        sum += x;
        System.out.println(x);
      }
    }


    System.out.println(sum);

  }
}


public class Main {
  public static void main(String[] args) {
    Eratosthenes finder = new Eratosthenes();
    finder.BuildAll();
    // 31875000
  }
}
