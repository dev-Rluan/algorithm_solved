#include <iostream>
using namespace std;
int GetCount(int k, int n) 
{
    if (n == 1)
    {
        return 1;
    }
    if (k == 0)
    {
        return n;
    }
    return GetCount(k, (n - 1)) + GetCount((k - 1), n);
}
int main()
{
    int t, k, n;
    cin >> t;
    for (int i = 0; i < t; i++)
    {
        cin >> k >> n;
        cout << GetCount(k, n) << endl;
    }
}
