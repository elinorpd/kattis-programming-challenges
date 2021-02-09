import itertools
import math

def nCr(n,k):
    if k>n:
        return 0
    else:
        return math.factorial(n) // (math.factorial(k)*math.factorial(n-k))


n = int(input())    # get the number of fruits
fruits = input().split()    # get the weights of the fruits
weights = sorted([int(x) for x in fruits])
totweight = sum(weights)    
tot = 0     # initial total is 0g
i=1     # start with baskets of 1 fruit

if n<=0:
    tot=0
elif n==1:
    if totweight >= 200:
        tot=totweight
else:
    min = 4
    # for groupings less than the min number, test each and only add to total if weight is >=200
    while i < min:
        for basket in itertools.combinations(weights, i):
            if sum(basket) >= 200:
                tot += sum(basket)
        i += 1

    # for all groupings with at least the min num fruits
    # we know the weight will be >=200 so add it automatically
    for j in range(min, n+1):
        tot += totweight*nCr(n-1,j-1)  # add the sum for each number of combinations for given selection 

print(tot)