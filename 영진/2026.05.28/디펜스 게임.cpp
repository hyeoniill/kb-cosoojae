#include<bits/stdc++.h>

using namespace std;

int solution(int n, int k, vector<int> enemy) {
    
    //항상 가장 큰 값 - 가장 어려웠던 라운드를 내보낼 pq
    priority_queue<int> pq;
    int answer =0;
    
    for(int i =0; i<enemy.size(); i++){
        pq.push(enemy[i]);
        
        int e = enemy[i];

        if(n >= e){
            //라운드를 통과 할 수 있으면 통과
            answer++;
            n -=e;
            continue;
        }else if(k <= 0) break;

        //라운드를 통과할 수 없고 k가 남아있다면
        //가장 어려웠던 라운드에서 k를 사용 
        int m = pq.top();
        pq.pop();
        n += m; // 사용한 병사 복구
        n -= e; // 이번 라운드 클리어
        k--;  
        answer++;
    }
    
    return answer;
}