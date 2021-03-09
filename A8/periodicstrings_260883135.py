s = input()  # string


def is_periodic(k):
    if len(s) % k != 0:  # can't have a cycle if it doesnt divide evenly
        return False

    # create a list of substrings
    substring_list = []
    for j in range(0, len(s), k):
        substring_list.append(s[j:j+k])

    for k in range(1, len(substring_list)):
        prev = substring_list[k - 1]
        prev = (prev[-1] + prev)[:-1]  # move last char to the beginning
        # check if the shifted string is equal to the current substring
        if substring_list[k] != prev:
            return False
    return True


for i in range(1, len(s) + 1):
    if is_periodic(i):
        print(i)
        break

