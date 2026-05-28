#include<bits/stdc++.h>

using namespace std;

int solve(int i, string s){
    string res = "";
    int count = 1;
    string prev = s.substr(0,i);
    
    for(int j=i; j<s.length();j +=i){
        string curr = s.substr(j,i);
        
        if(prev == curr){
            count++; // 중첩개수
        }else{
            if( count > 1) res += to_string(count);
            res += prev;
            
            prev = curr;
            count = 1;
        }
    }
    
    if(count >1) res += to_string(count);
    res +=prev;
    
    return res.length();
}

int solution(string s) {
    int m = 1004;
    if(s.length() == 1) return 1;

    for(int i =1; i<=s.length()/2; i++){
        m = min(m,solve(i,s));
    }
    
    return m;
}