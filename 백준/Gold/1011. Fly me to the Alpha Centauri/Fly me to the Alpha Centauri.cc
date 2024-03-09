#include <iostream>
#include<cmath>
using namespace std;
int main() 
{
	int t, x, y, sqt;
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		int numCheck = 0, cnt = 0;
		cin >> x >> y;
		x = y - x;
		sqt = sqrt(x);
		cnt = (sqt * 2) - 1;
		x = x - pow(sqt, 2);
		if (x % sqt != 0)
		{
			cnt++;
		}
		cnt += x / sqt;
		
		cout << cnt << endl;
	}
}