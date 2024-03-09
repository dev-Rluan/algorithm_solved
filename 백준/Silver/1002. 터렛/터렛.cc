#include <iostream>
using namespace std;
int main()
{
    // 두 점 사이의 거리
    // (x-2)
    int t,x1, y1, r1, x2, y2, r2, len;
    cin >> t;
    for (int i = 0; i < t; i++)
    {
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
        len = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        int rad1 = (r1 - r2) * (r1 - r2);
        int rad2 = (r1 + r2) * (r1 + r2);
        if (len == 0)
        {
            if (r2 == r1)
                cout << "-1" << endl;
            else
                cout << "0" << endl;
        }
        else if (len == rad1 || len ==rad2)
            cout << "1" << endl;
        else if (len < rad2 && len > rad1)
            cout << "2" << endl;
        else
            cout << "0" << endl;
    }
}
