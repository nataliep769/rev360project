cont = "y"
gradebook = {}
while cont = "y":#put something here
    grade = input("Your grade (0.0-4.0)")
    grade = float(grade)

    credits = input("credits:")
    credits = int(credits)

    gradebook[grade] = credits
    cont = input("Enter another grade? [y/n]: ")
    while cont != "y" and cont != "n":
        cont = input("Enter another grade? [y/n]: ")

qualityScore = 0
credits = 0

for (k,v) in gradebook.items():
    qualityScore += k * v
    credits += v

print("Total GPA: " + str(qualityScore/credits))
