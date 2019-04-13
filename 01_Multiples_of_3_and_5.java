Set<Integer> euler  = new HashSet<>();

for (Integer i=0; i<1000; i+=3){
    euler.add(i);
}
for (Integer i=0; i<1000; i+=5){
    euler.add(i);
}

int sum = 0;
for (Integer x : euler) {
    sum += x;
}
