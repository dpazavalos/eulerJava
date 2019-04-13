List<Integer> eulerList = new ArrayList<Integer>();
int toFactor = 13195;

// Tool to produce product from array
public static Integer arrprod(ArrayList<Integer> arrInt) {
  Integer product = 1;
  for (Integer x : arrInt){
    product *= x;
  }
  return product;
}

// Find smallest factor
for (i; i<toFactor/2; i++; ){
  if (toFactor%i == 0){
    eulerList.add(i);
    break;
  }
}

while (arrprod(eulerList)!=toFactor) {;}


// ((7/2) && (7%2));
