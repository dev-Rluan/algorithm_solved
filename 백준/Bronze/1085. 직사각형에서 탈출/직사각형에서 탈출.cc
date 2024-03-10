#include <iostream>
using namespace std;
// 오른쪽이 무조건 큰 값
int SmallValue(int num1, int num2)
{
	if ((num2 - num1) < num2 + (num1 - num2))
	{
		return num2 - num1;
	}
	return num2 + (num1 - num2);
}
int main()
{
	int x, y, w, h;
	cin >> x >> y >> w >> h;
	x = SmallValue(x, w);
	y = SmallValue(y, h);
	if (x < y)
	{
		cout << x << endl;
	}
	else
	{
		cout << y << endl;
	}

}
