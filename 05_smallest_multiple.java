import java.lang.Integer;

class FactorFinder {

  // Target
  final private Integer DIVMAX = 20;

  /**
   * Checks if Integer is dividable by numbers 1::DIVMAX
   *
   * @param target Integer to check
   * @return       True/False indicating if dividable
   */
  private boolean factorable(Integer target) {
    boolean factorable = true;
    int x;
    for (x=DIVMAX; x>0; x--) {
      if (!(target%x==0)){
        factorable = false;
        break;
      }
    }
    return factorable;
  }

  /**
   * Finds the smallest number that can be evenly divided by each of the numbers 1::DIVMAX
   *
   * @return smallest positive number that is evenly divisible by all numbesrs 1-20
   */
  Integer FindLargestFactor(){
    Integer target = DIVMAX;
    while (true){
      if (factorable(target)) {
        break;
      }
      else {
        target += DIVMAX;
      }
    }
    return target;
  }
}

public class Main {
  public static void main(String[] args) {
    FactorFinder finder = new FactorFinder();
    System.out.println(finder.FindLargestFactor());
    // 232792560
  }
}

