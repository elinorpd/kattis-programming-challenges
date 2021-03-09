import math
x = int(input())
m = 0 # number of men
w = 0 # number of women
line = list(input()) # the list containing women and men
l = len(line)

for i, p in enumerate(line):
    if p == 'W':
        if (int(math.fabs(m-(w+1)))>x) and (i < l+1): # difference is more than x and not at end of line
            if line[i+1] == 'M': # but next person is a man, let the man cut
                m+=1
                line[i+1] = 'W' # woman switched places with man
            else: 
                break # because we have exceeded the threshold and next person is also a woman
        else:
            w+=1 # have not exceeded x, let the woman in

    else: # p = 'm'
        if (int(math.fabs(w-(m+1)))>x) and (i < l+1): # difference is more than x and not at end of line
            if line[i+1] == 'W': # but next person is w, let w cut
                w+=1
                line[i+1] = 'M' # m switched places with w
            else: 
                break # because we have exceeded the threshold and next person is also m
        else:
            m+=1 # have not exceeded x, let m in

print(m+w)

    