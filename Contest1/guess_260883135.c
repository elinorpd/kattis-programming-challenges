// imports 
#include <stdio.h> 
#include <math.h>
char feedback [10]; // make buffer to read into

int guess(int lo, int hi) {
	// get the midpoint
	int mid = (lo + hi)/2;
	fprintf(stdout, "%d\n", mid);
    fflush(stdout);
	scanf("%s", feedback); // get feedback
    if (feedback[0] == 'c') return 0; // guess was correct!
	if (feedback[0] == 'l') return guess(lo, mid-1);
	else return guess(mid+1, hi);
}

int main() {
	while (guess(1,1000));
	return 0;
}
