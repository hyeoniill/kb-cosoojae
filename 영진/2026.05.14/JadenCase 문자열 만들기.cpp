#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    
    int idx = 0;
    for(int i =0; i<s.length(); i++){
        if(s[i]==' '){
            idx = i+1;
        }
        else if(i==idx) s[i] = toupper(s[i]);
        else{
            s[i] = tolower(s[i]);
        }
    }
    
    return s;
}