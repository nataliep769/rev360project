counts = {}

def count_my_letters(x):
    for char in x:
        if char in counts:
            counts[char] += 1
        else:
            counts[char] = 1

    for (k, v) in counts.items():
      print(k + ": " + str(v))

count_my_letters("How are you doing?")
