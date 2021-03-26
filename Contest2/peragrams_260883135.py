s = input()
chardict = {}
for char in s: # find frequencies of chars in the string
    if char not in chardict:
        chardict[char]=1
    else:
        chardict[char]+=1

remove = -1 # we can tolerate only one odd frequency character (middle of palindrome)
for freq in chardict.values():
    if freq%2 != 0: # if the char freq is not even, then we must remove it
        remove+=1
if remove > 0:
    print(remove)
else:
    print(0)