#include<bits/stdc++.h>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    unordered_map<string,int> m;
    
    for(int i =0; i < want.size(); i++){
        m[want[i]] = number[i];
    }
    
    for(int i =0; i<10; i++){
        if(m.find(discount[i]) != m.end()){
            m[discount[i]]--;
        }    
    }
    
    for(int right = 9; right<discount.size(); right++){
        answer++;    
     
        for(auto i : m ){
            if(i.second > 0){
                answer--;break;
            }
        }   
        
        if(right==discount.size()-1) return answer;
        
        int left = right-9;
        
        if(m.find(discount[left]) != m.end()){
            m[discount[left]]++;
        }

        if(m.find(discount[right+1]) != m.end()){
            m[discount[right+1]]--;
        }
        
    }
    
    return answer;
}