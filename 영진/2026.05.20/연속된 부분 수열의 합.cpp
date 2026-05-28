#include<bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> sequence, int k) {
        vector<int> answer;
        int m = sequence.size();
    
        int size = sequence.size();
        
        int start = 0;
        int end = 0;
        int sum =sequence[0];
    
        while(end<size){
            if(sum == k){
                // 더 작은 부분수열을 찾은 경우
                // 크기가 같으면 갱신 안 함
                if(end-start < m){
                    m = end-start;
                    answer= {start,end};
                    // if(m == 0) return answer;
                }
                // 더 나은 경우의 수를 찾기 위해 start++
                sum -= sequence[start];
                start++;
            }else if(sum > k){
                sum -= sequence[start];
                start++;
            }else{ // sum < k
                end++;
                if(end<size) sum += sequence[end];
            }
        }
    
    return answer;
}