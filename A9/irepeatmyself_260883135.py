t = int(input()) # num test cases
for j in range(t):
    s = input() # the input string

    not_done = True
    n = len(s)
    for i in range(1,n):
        if s == (s[:i]*n)[:n]:
            not_done = False
            print(i)
            break

    if not_done:
        print(n)