/**
 * Question:
 *  By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime
 *  is 13. What is the 10,001st prime number?.
 *
 * Solution
 *  Create array of prime numbers. Add new primes via checking odd numbers against largest current
 *  known prime, second largest known, etc. Repeat till 10,001st
 *
 */

import java.util.ArrayList;
import java.lang.Long;

class PrimeFinder {

  private ArrayList<Long> FOUNDPRIMES = new ArrayList<Long>();

  /**
   * Quick access to FOUNDPRIMES[-1]
   *
   * @return FOUNDPRIMES[-1]
   */
  private long LastPrimeFound(){
    return FOUNDPRIMES.get(FOUNDPRIMES.size()-1);
  }

  /**
   * Checks if target, against all currently found prime numbers
   *
   * @param target Integer to check
   * @return Bool indicating is a bool
   */
  private boolean IsPrime(long target) {
    boolean isPrime = true;
    for (long prime : FOUNDPRIMES) {
      if (target%prime == 0) {
        isPrime = false;
        break;
      }
    }
    return isPrime;
  }

  /**
   * Counting from last found prime, identify next prime integer
   *
   * @returns Next prime number, counting from last prime found
   */
  private long FindNextPrime() {
    long x;
    long foundPrime = 0;
    long CEILING = Long.MAX_VALUE;
    long start = LastPrimeFound()+2;  // Odds only
    for (x=start; x< CEILING; x+=2) {
      if (IsPrime(x)){
        foundPrime = x;
        break;
      }
      if (x> CEILING -10){
        throw new IllegalStateException("Gone over the type's max value!");
      }
    }
    return foundPrime;
  }

  /**
   * Finds the smallest number that can be evenly divided by each of the numbers 1::SQMAX
   *
   * @return smallest positive number that is evenly divisible by all numbesrs 1::SQMAX
   */
  long FindAPrime(){
    // prep known primes, 2 and three (simplifies odd checks
    FOUNDPRIMES.add(2L);
    FOUNDPRIMES.add(3L);
    int x;
    int TARGET = 10_001;
    for (x=1; x< TARGET; x++){
      FOUNDPRIMES.add(FindNextPrime());
    }
    return LastPrimeFound();
  }
}

public class Main {
  public static void main(String[] args) {
    PrimeFinder finder = new PrimeFinder();
    System.out.println(finder.FindAPrime());
    // 104743
  }
}
