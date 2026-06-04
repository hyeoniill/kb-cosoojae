#include<bits/stdc++.h>

using namespace std;

//시간초과 뜸 효율성 0점
//O(N x M) 

//cpp이라 split 직접 구현
vector<string> split(string s, string d){
    vector<string> answer;
    auto pos = s.find(d);
    string temp = "";
    while(pos != string::npos){
        pos = s.find(d);
        temp = s.substr(0,pos);
        answer.push_back(temp);
        s.erase(0,pos+d.size());
    }
    
    return answer;
}

vector<int> solution(vector<string> info, vector<string> query) {
    
     vector<int> answer;
    
    for(int i = 0; i<query.size(); i++){
        int count = 0;

        //query의 값을 split으로 나누어 저장
        vector<string> want = split(query[i]," and ");
        string temp = want.back(); //string
        want.pop_back(); 
        for(string s : split(temp," ")){
            want.push_back(s);
        }


        
        for(int j =0; j<info.size(); j++){
            //성공 했다 가정하고 count ++
            count++;
            vector<string> v = split(info[j]," ");
            for(int k = 0; k<5; k++){
                //성공 못 하면 count--
                if(want[k] == "-") continue;
                if(k == 4){
                    if(stoi(want[4]) > stoi(v[4])) {
                        count--;
                    }
                    break;
                }
                if(want[k] != v[k]) {
                    count--; 
                    break;
                }
            }
        }
        answer.push_back(count);
    }
    
    return answer;
}