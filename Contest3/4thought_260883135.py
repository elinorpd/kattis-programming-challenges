ops = {'+':'+', '-':'-', '*':'*', '//':'/'}
values = {} # stores all possibilities where key=total value= operations used
for a in ops:
    for b in ops:
        for c in ops:
            values[eval(f"4{a}4{b}4{c}4")]= f"4 {ops[a]} 4 {ops[b]} 4 {ops[c]} 4 ="
t = int(input()) # num test cases
for case in range(t):
    target = int(input()) # target value
    if target in values.keys():
        print(values[target], target)
    else:
        print('no solution')