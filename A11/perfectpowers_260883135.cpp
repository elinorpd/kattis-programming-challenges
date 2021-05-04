#include<iostream>
#include<cmath>

using namespace std;

int main() {
    long double n; 
    cin >> n;
    while (n != 0) {
        bool neg = false;
        if (n < 0) {
            neg = true;
        }
        n = abs(n); // take abs val so we dont get negative roots

        // we start with largest power that n can be a perfect power
        // and then decrement power to print largest one first
        for(long long p = sqrt(n)+1; p > 0; p--) {  
            if (neg && p%2 == 0) {
                continue; // skip even powers for neg numbers
            }
            long double r = pow(n, 1/((long double) (p))); // p-th root
            if (abs(r - floor(r)) < .00001) {
                // r is a whole number --> n is a perfect power for p
                cout << p << endl;
                break;
            }
        }
        cin >> n;
    }

    return 0;
}