#include<iostream>
#include<vector>
#include<map>
using namespace std;
int countRepeatedRequestIds(vector<string> requestIDs, vector<int> timestamps, int timeWindow) {
    map<string,vector<int>> reqs;
    int n=requestIDs.size();
    for(int i=0;i<n;i++) {
      reqs[requestIDs[i]].push_back(timestamps[i]);
    }

    int ans=0;
    for(auto it:reqs) {
       vector<int> temp=it.second;
      int m=temp.size();
      for(int i=0;i<m-1;i++) {
          int gap=temp[i+1]-temp[i];
        if(gap<=timeWindow) {
          ans++;
        }
      }
    }
    return ans;
}
int main() {
    vector<string> requestIDs = {"req1", "req1", "req1", "req2", "req2"};   
    vector<int> timestamps = {100,105,200,300,302};
    int timeWindow = 5;
    cout << countRepeatedRequestIds(requestIDs, timestamps, timeWindow) << endl;
    return 0;
}