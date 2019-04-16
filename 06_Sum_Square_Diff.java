/**
 * Question:
 *  The sum of the squares of the first ten natural numbers is 1^2 + 2^2 + ... + 10^2 = 385
 *  The square of the sum of the first ten natural numbers is (1 + 2 + ... + 10)^2 = 55^2 = 3025
 *  Hence the difference between the sum of the squares of the first ten natural numbers and the
 *  square of the sum is
 *  3025 − 385 = 2640.
 *
 *  Find the difference between the sum of the squares of the first one hundred natural numbers and
 *  the square of the sum.
 *
 * Solution
 *  For loops. Literally just two four loops in a dedicated class
 *
 */

class DiffFinder {
  final private int SQMAX = 100;

  /**
   * Finds the sum of the squares of natural numbers 1::SQMAX
   *
   * @return       Sum of squares
   */
  private int SumOfSquares() {
    int x;
    int sum = 0;
    for (x=0; x<SQMAX+1; x++) {
      sum += x*x;
      System.out.println(sum);
    }
    return sum;
  }

  /**
   * Finds the sum of the squares of natural numbers 1::SQMAX
   *
   * @return       Sum of squares
   */
  private int SquareOfSum() {
    int x;
    int sum = 0;
    for (x=0; x<SQMAX+1; x++) {
      sum += x;
    }
    sum *= sum;
    return sum;
  }

  /**
   * Finds the smallest number that can be evenly divided by each of the numbers 1::SQMAX
   *
   * @return smallest positive number that is evenly divisible by all numbesrs 1::SQMAX
   */
  int FindDiffSumSquare(){
    return SquareOfSum()-SumOfSquares();
  }
}

public class Main {
  public static void main(String[] args) {
    DiffFinder finder = new DiffFinder();
    System.out.println(finder.FindDiffSumSquare());
    // 235251
  }
}

