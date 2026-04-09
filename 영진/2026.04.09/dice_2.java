import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = {a,b,c,d};
        Arrays.sort(arr);

        Set<Integer> a_set = new HashSet<>();
        Set<Integer> b_set = new HashSet<>();

        for(int n : arr){
            if(!a_set.add(n)){
                b_set.add(n);
            }
        }

        int answer = 0;

        if(a_set.size() == 1){
            answer = arr[0]*1111;
        }
        else if(a_set.size() == 2){
            if(b_set.size()==2){
            List<Integer> list = new ArrayList<>(a_set);
            int p = list.get(0);
            int q = list.get(1);
            answer = (p+q)*Math.abs(p-q);
                }
            else{
                int p = arr[1];
                int q = 0;
                for (int n : a_set){
                    if(n!=p) q=n;
                }
                answer = (int) Math.pow(10*p +q,2);
            }
        }
        else if(a_set.size() == 3){
            int p = 0;
            for (int n : b_set) p =n;

            answer = 1;

            for ( int n : a_set){
                if(n != p) answer *= n;
            }
        }
        else{
            answer = arr[0];
        }


        return answer;
    }
}
