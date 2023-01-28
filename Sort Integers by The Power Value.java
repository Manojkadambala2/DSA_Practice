//Sort Integers by The Power Value

import java.util.*;
class Solution {
    public int getKth(int lo, int hi, int k) {
        List<Po> list = new ArrayList<>();
        for(int i=lo; i<=hi; i++){
            int count = 0;
            int temp = i;
            while(temp != 1){
                if((temp&1) != 0){
                    temp = 3*temp+1;
                    count++;
                }else{
                    temp = temp >> 1;
                    count++;
                }
            }
            list.add(new Po(i, count));
        }
        Collections.sort(list, new Comparator<Po>() {
            @Override
            public int compare(Po o1, Po o2) {
                return o1.value.compareTo(o2.value);
            }
        }); 

        return list.get(k-1).key;
    }
}

class Po{
    Integer key;
    Integer value;
    public Po(Integer k, Integer v){
        this.key = k;
        this.value = v;
    }
}
