'''0 iterations, 2^2
1 iteratino, 3^2 = (2^1+1)^2
2 iteration 5^2=(2^2+1)^2
pattern is (2^n+1)^2'''

n = int(input())
print(((2**n)+1)**2)