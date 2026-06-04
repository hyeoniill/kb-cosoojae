#include<bits/stdc++.h>

using namespace std;

bool solution(string s)
{
    int countP = 0;
    int countY = 0;
    for(char c : s){
        c = tolower(c);
        if(c == 'p'){
            countP++;
            continue;
        }
        if(c == 'y'){
            countY++;
            continue;
        }
    }
    
    if(countP == countY) return true;

    return false;
}