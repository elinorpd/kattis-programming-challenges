inputs = input().split()
e = int(inputs[0])
f = int(inputs[1])
c = int(inputs[2])

empty = e + f
total = 0
while empty >= c:
    empty -= c
    total += 1
    empty += 1
print (total)
