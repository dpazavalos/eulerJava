/**
 * Question:
 *  The prime factors of 13195 are 5, 7, 13 and 29.
 *  What is the largest prime factor of the number 600851475143 ?
 *
 * Solution:
 *  From 1, find factors of our tar
 */

/*


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
    for (Long x=lastFactor+1; x<TO_FACTOR; x++){
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
      Long nextFactor = NextFactor(eulerList.get(eulerList.size()-1));
      eulerList.add(nextFactor);
    }
    System.out.println(eulerList);                  // Factors: [1, 71, 839, 1471, 6857]
    System.out.println(ArrProd(eulerList));         // Product: 600851475143
    System.out.println(eulerList.get(eulerList.size()-1));  // Largest: 6857

  }
}

