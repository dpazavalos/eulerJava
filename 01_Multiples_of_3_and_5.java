/**
 * Question:
 *  If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 *  The sum of these multiples is 23.
 *  Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * Solution:
 *  Create a set to ensure unique values only. Pass through range 1000 twice at step intervals 3&5
 *  (Step intervals ensure we only hit 533 numbers (1000/3=333, 1000/5=200), rather than mod check
 *  against 1000 numbers)
 *  For loop to find sum
 */

/**
 *
 *  The prime factors of 13195 are 5, 7, 13 and 29.
 *  What is the largest prime factor of the number 600851475143 ?
 *
 * Solution:
 *  Find prime factors of our To_FACTOR target using modulo math. Once a prime factor is found,
 *  check the product of our factors to see if we've found all factors or not. If not, start
 *  checking from the last found factor until the next.
 *  Largest prime factor is last factor found.
 */

import java.util.Set;
import java.util.HashSet;
import java.lang.Integer;

public class Main {

  public static void main(String[] args) {

    // Build Set
    Set<Integer> euler  = new HashSet<>();
    // Parse through ranges at step intevals, pass into set
    for (Integer i=0; i<1000; i+=3){
      euler.add(i);
    }
    for (Integer i=0; i<1000; i+=5) {
      euler.add(i);
    }
    // Sum
    int sum = 0;
    for (Integer x : euler) {
      sum += x;
    }
    System.out.println(sum);  // 233168
  }
}

