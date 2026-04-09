import jave.util.Map;
import jave.util.HashMap;

class Solution {
    public int solution(int a, int b, int c, int d) {
     Map <Integer> map = new HashMap();
        map.put(a, map.getOrDefault(a,0)+1);
        map.put(b, map.getOrDefault(b,0)+1);
        map.put(c, map.getOrDefault(c,0)+1);
        map.put(d, map.getOrDefault(d,0)+1);
        
        if(map.size() == 4 ){
            for(int key : map.keySet()){
                if (key < min) min = key;
                
            } return min;
            
        }//4일때 사이즈가 4일때
         if(map.size() == 3){
             
                for(int key : map.keySet()){
                    if (map.get(key) == 1){
                        
                    }
                }

            
        } 
        
        
        
        if(map.size() == 2 ){
            
             
             
        } if(map.size() == 1 ){
            int p = a;
             return 1111*p;
             
        }

        
        //추후 업데이트 예정
        
    }
}
