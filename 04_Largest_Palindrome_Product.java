import java.lang.Integer;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.lang.Math;
import java.lang.Thread;


class PalindromeFinder {
  // Catches found palindromes from worker threads
  private Set<Integer> FOUNDPALS = new HashSet<>(0);

  // Largest palindrome found so far. Used for worker early break
  private Integer LARGESTPAL = 0;

  // Set of roots used to spawn WorkerFindPalindromes. While loaded, work is occuring
  private Set<Integer> WORKINGROOTS = new HashSet<>();

  // Utility methods
  /**
   * Given a string, returns it's reverse
   */
  private static String ReverseString(String toReverse) {
    ArrayList<String> reversedArr = new ArrayList<>();
    int x;
    for (x = toReverse.length() - 1; x >= 0; x--) {
      String s = String.valueOf(toReverse.charAt(x));
      reversedArr.add(s);
    }
    return String.join("", reversedArr);
  }

  /**
   * Returns bool indicating if integer is palindrome
   */
  private static boolean IsPalindrome(Integer toCheck) {
    return (toCheck.toString().equals(ReverseString(toCheck.toString())));
  }

  /**
   * Using unique root (999 or 998 or ...), count from 999 down. Add first (and largest) palindrome
   * to class-wide FOUNDPALS, and close thread. Includes check against current largest palindrome
   * (if LARGSETPAL=90909 and working product is below, stop searching)
   */
  class WorkerFindPalindrome extends Thread {
    void run(Integer root) {
      WORKINGROOTS.add(root);
      Integer numTwo = 999;
      Integer product;

      product = root * numTwo;
      while (numTwo >= 100 && product >= LARGESTPAL) {
        // Check if valid palindrome
        if (IsPalindrome(product)) {
          FOUNDPALS.add(product);
          break;
        }
        numTwo -= 1;
        product = root * numTwo;
      }
      WORKINGROOTS.remove(root);
    }
  }

  /**
   * Boss. Calls threads and locates largest palindrome
   */
  // Boss Helper, Updates LARGESTPAL
  private void UpdateLARGESTPAL(){
    for (Integer x : FOUNDPALS) {
      LARGESTPAL = Math.max(LARGESTPAL, x);
    }
  }
  Integer FindLargestPalindrome() {

    // Max # of threads boss will spool
    int maxThreads = 50;

    // Add Root 0 to WORKINGROOTS to signify work has begun
    WORKINGROOTS.add(0);

    // Build and call Workers to find palindrome from a given root, thread limit wise
    int rootToSend;
    for (rootToSend = 999; rootToSend > 100; rootToSend -= 0) {
      if (WORKINGROOTS.size() < maxThreads) {
        WorkerFindPalindrome finder = new WorkerFindPalindrome();
        finder.run(rootToSend);
        System.out.println("Root " + rootToSend + " spooled");
        rootToSend -= 1;
      }
      // Update class_wide max palindrome, so threads can use it for quick exit
      UpdateLARGESTPAL();
    }

    // Boss has built all workers needed. Remove Root 0, Wait for workers to finish
    WORKINGROOTS.remove(0);
    boolean finished;
    do {
      finished = WORKINGROOTS.isEmpty();
    } while (!finished);

    // Final check
    UpdateLARGESTPAL();
    return LARGESTPAL;
  }
}

public class Main {
  public static void main(String[] args) {
    PalindromeFinder finder = new PalindromeFinder();

    System.out.println(finder.FindLargestPalindrome());
  }
}

