import string
from helpers import alphabet_position, rotate_character

def encrypt(text, rot):
    cipher = ""
    for char in text:
        cipher = cipher + rotate_character(char, rot)
    return cipher

def main():
    letter = input("Please type a letter ")
    print(alphabet_position(letter))

    char= input("Please type a character ")
    rot = input("Rotate by: ")
    print(rotate_character(char, rot))

    text = input("Please type some text ")
    rot = input("Rotate by: ")
    print(encrypt(text, rot))

if __name__ == '__main__':
    main()
