/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
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

