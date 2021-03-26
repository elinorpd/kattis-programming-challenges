import math
num_tests = int(input())
for i in range(num_tests):
    num_cmds = int(input())
    x,y = 0,0
    theta = 0
    for j in range(num_cmds):
        cmd,v = map(str, input().split())
        v = int(v)
        if cmd == "fd":
            x += v*math.sin(theta)
            y += v*math.cos(theta)
        elif cmd == "bk":
            x -= v*math.sin(theta)
            y -= v*math.cos(theta)
        elif cmd == "lt":
            theta += math.radians(v)
        elif cmd == "rt":
            theta -= math.radians (v)

    print(round(math.sqrt(x**2+y**2)))
