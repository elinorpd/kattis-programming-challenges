import itertools

def hash(s):
    res = 0
    for c in s:
        res ^= ord(c)   # xor each char in string
    return res


def counter(files):
    collision = 0
    unique = 0
    for hashval, value in files.items(): # for each hash value and dict of lines
        if value[0] > 1:  # only count overfilled hash slots
            unique += len(value[1]) # the num of lines in the hash slot is the num of unique
            # get the unique combinations of the collided lines
            combos = itertools.combinations([v[1] for v in value[1].items()], 2)
            for pair in combos:
                collision += pair[0]*pair[1]
        else:   # if hash slot has only one line in it
            unique += 1
    return unique, collision


while True:
    n = int(input())    # get the number of tests
    if n == 0:
        break

    files = {}  # key = hash; value = [n, {}] where n is the # of times something hashed to the slot
    for i in range(0, n):
        line = input()  # get input line
        hashed = hash(line)

        if hashed not in files:  # if hash doesnt exist yet
            files[hashed] = [1, {}]  # second index is dict to keep track of lines w same hash
        else:
            files[hashed][0] += 1  # keep track of the number of items at the hash index of the dict

        # counting real duplicates vs collisions in particular hash slot
        if line not in files[hashed][1]:  # [0, {}]
            files[hashed][1][line] = 1  # line is dict key in sub dict
        else:
            files[hashed][1][line] += 1  # key already exists, increment it
    
    numu, numc = counter(files)
    print(numu, numc)  # count and print the duplicate and hash collisions counts