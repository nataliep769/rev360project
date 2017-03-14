def get_initials(fullname):
    namelist = fullname.split()
    total = ""
    for aname in namelist:
        total = total + aname[0]
    return total.upper()

def main():
    fullname = input("What is your full name?")
    print(get_initials(fullname))

if __name__ == '__main__':
    main()
