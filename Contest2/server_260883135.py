n, T = map(int, input().split())
tasks = input().split()

i = 0
time = 0
for task in tasks:
    task = int(task)
    if (time + task) <= T:
        time += task
        i+=1
    else:
        break
print(i)
