/**
 * Question:
 *  The prime factors of 13195 are 5, 7, 13 and 29.
 *  What is the largest prime factor of the number 600851475143 ?
 *
 * Solution:
 *  Find prime factors of our To_FACTOR target using modulo math. Once a prime factor is found,
 *  check the product of our factors to see if we've found all factors or not. If not, start
 *  checking from the last found factor until the next.
 *  Largest prime factor is last factor found.
 */

import java.util.ArrayList;
import java.lang.Long;
import java.util.Collections;

public class Main {

  // private final static Long TO_FACTOR = 13195L;
  private final static Long TO_FACTOR = 600851475143L;

  // Tool to find product from ArrayList
  private static Long ArrProd(ArrayList<Long> arrLong) {
    Long product = 1L;
    for (Long x : arrLong){
      product *= x;
    }
    return product;
  }

  // Given The last factor found against TO_FACTOR, return the next highest one
  private static Long NextFactor(Long lastFactor){
    Long next = 0L;
    for (Long x=lastFactor+1; x<TO_FACTOR; x += 2){ // Assuming odd numbers only
      if (TO_FACTOR %x == 0){
        next = x;
        break;
      }
    }
    return next;
  }

  public static void main(String[] args) {
    // Find each factor using modulo check. Keep searching while product of all found is < target
    // number
    ArrayList<Long> eulerList = new ArrayList<>();  // Holds our factors
    eulerList.add(1L); // used to start factor checks. WIll not interfere with final product
    while (ArrProd(eulerList)< TO_FACTOR) {
      eulerList.add(NextFactor(eulerList.get(eulerList.size()-1)));
    }
    System.out.println(eulerList);                          // Factors: [1, 71, 839, 1471, 6857]
    // ArrayList is order preserving, so...
    System.out.println(eulerList.get(eulerList.size()-1));  // Largest: 6857
  }
}

