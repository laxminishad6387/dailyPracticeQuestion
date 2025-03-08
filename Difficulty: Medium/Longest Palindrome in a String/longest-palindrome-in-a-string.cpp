//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
public:
    string longestPalindrome(string &s) {
        if (s.empty()) return "";
        int start = 0, end = 0;
        
        for (int i = 0; i < s.size(); i++) {
            int len1 = expandFromCenter(s, i, i); // odd-length palindrome
            int len2 = expandFromCenter(s, i, i + 1); // even-length palindrome
            int len = max(len1, len2);
            
            if (len > (end - start + 1)) { // Fix here
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substr(start, end - start + 1);
    }
    
private:
    int expandFromCenter(const string &s, int left, int right) {
        while (left >= 0 && right < s.size() && s[left] == s[right]) {
            left--;
            right++;
        }
        return right - left - 1; // Length of palindrome
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string S;
        cin >> S;

        Solution ob;
        cout << ob.longestPalindrome(S) << endl;

        cout << "~"
             << "\n";
    }
}

// } Driver Code Ends