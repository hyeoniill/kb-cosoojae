#include <bits/stdc++.h>

using namespace std;

long long solution(int n, vector<int> times) {
   
    long long answer =0;
    sort(times.begin(), times.end());
    
    int size = times.size();
    
    
    long long start = 1;
    long long end = (long long) times.back()*n;
    
    while(start<=end){
        long long sum=0;
        long long mid = (end+start)/2;
        for(long long time : times){
            sum += mid/time;
            if(sum >= n) {
                answer = mid;
                end = mid-1;
                break;
            }
        }
        if(sum < n){
            start = mid+1;
        }
       
    }
    
    return answer;
}