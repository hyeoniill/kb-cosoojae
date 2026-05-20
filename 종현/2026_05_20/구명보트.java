/* 구명보트 No.42885 */

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int boatRequired = 0;
            
        Arrays.sort(people);
        int maxIndex = people.length-1;
        int minIndex = 0;
        
        while(maxIndex >= minIndex) {
            int currentWeight = people[maxIndex]+people[minIndex];
            if(currentWeight <= limit) {
                boatRequired++;
                minIndex++;
                maxIndex--;
                continue;
            } else {
                boatRequired++;
                maxIndex--;
                continue;
            } 
        }
        
        return boatRequired;
    }
}
