import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int num[] = {a,b,c,d};
        Arrays.sort(num);
        
        if(num[0] == num[3]){
            return 1111*num[0];
        }
        else if(num[0] == num[2] || num[1] == num[3]){
            
            int q =0 ;
            for(int i=0; i<4; i++){
                if(num[i] != num[1]){
                    q = num[i];
                }
            }
            return (10*num[1]+q)*(10*num[1]+q);
        }
        else if(num[0] == num[1] || num[1] == num[2] || num[2] == num[3]){
            if(num[0] == num[1]){
                    if(num[2] == num[3]){
                        return (num[0]+num[2])*(num[2]-num[0]);
                    } 
                    else{
                        return (num[2]*num[3]);
                    }
                }
            else if(num[2] == num[3]){
                return num[0]*num[1];
            }
            else return num[0]*num[3];
        }
        else{
            return num[0];
        } 
    }
}
