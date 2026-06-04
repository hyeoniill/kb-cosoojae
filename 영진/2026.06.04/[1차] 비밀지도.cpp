#include<bits/stdc++.h>


using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    vector<int> v;
    for(int i =0; i<n; i++){
        v.push_back(arr1[i] | arr2[i]);
    }
    for(int i =0; i<n; i++){
        string s ="";
        for(int j =0; j<n; j++){
            if(v[i]%2 == 1){s+='#';}
            else{
                s +=' ';
            }
            v[i] >>=1;
        }
        reverse(s.begin(),s.end());
        answer.push_back(s);
    }
    
    return answer;
}