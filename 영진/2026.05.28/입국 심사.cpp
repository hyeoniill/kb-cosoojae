#include <bits/stdc++.h>

using namespace std;

//시간초과

long long solution(int n, vector<int> times) {
    long long cnt = 0;
    
    priority_queue<vector<long long>> pq;
    
    unordered_map<int,int> m;
    sort(times.begin(),times.end());
    
    for(int i =0;i<times.size(); i++){
        m[i] = 1;
        pq.push({-times[i],i});
    }
    
    
    vector<long long> v;
  
    while(cnt !=n){
        v = pq.top();
        pq.pop();
        pq.push({ (long long)-times[v[1]]*(++m[v[1]]),  v[1] });
        cnt++;
    }
    
    return -v[0];
}