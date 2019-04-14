/*
The prime factors of 13195 are 5, 7, 13 and 29.
What is the largest prime factor of the number 600851475143 ?
*/

public static ArrayList<Integer> eulerList = new ArrayList<Integer>();
// public static Integer TOFACTOR = 13195;
public static BigInteger TOFACTOR = new BigInteger("600851475143");

// Tool to produce product from array
public static Integer ArrProd(ArrayList<Integer> arrInt) {
  Integer product = 1;
  for (Integer x : arrInt){
    product *= x;
  }
  return product;
}

// Given The last factor found against TOFACTOR, return the next highest one
public static Integer NextFactor(Integer lastFactor){
  Integer next = 0;
  for (int x=lastFactor+1; x<TOFACTOR/2; x++){
    if (TOFACTOR%x == 0){
      next = x;
      break;
    }
  }
  return next;
}

// ((7/2) && (7%2));

// Primary logic
eulerList.add(1); // used to start factor checks. WIll not interfere with final product
while (ArrProd(eulerList)<TOFACTOR) {
  Integer nextFactor = NextFactor(eulerList.get(eulerList.size()-1));
  eulerList.add(nextFactor);
}

