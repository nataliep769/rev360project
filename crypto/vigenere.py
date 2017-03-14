import string
from helpers import alphabet_position, rotate_character

def encrypt(text, word):
    vigenere = ""
    counter = 0
    for n in range(len(text)):
        if text[n] in string.ascii_letters:
            text_letter = text[n] #I think the reason for this is because our text is already at a certain length(shorter or longer)
            rotation = word[(n + counter) % len(word)] #We want to save the position of the letter in word while printing the number inputted for text
            rotation = rotation.lower()
            position = string.ascii_lowercase.index(rotation)
            vigenere = vigenere + rotate_character(text_letter, position)
        else:
            text_letter = text[n] #I think the reason for this is because our text is already a certain length(shorter or longer)
            counter -= 1
            rotation = word[(n + counter) % len(word)]
            rotation = rotation.lower()#We want to save the position of the letter in word while printing the number inputted for text
            position = string.ascii_lowercase.index(rotation)
            vigenere = vigenere + rotate_character(text_letter, position)
    return vigenere

def main():
    text = input("Please enter the text you would like encrypted ")
    word = input("Please enter the word that will make your encryption ")
    print(encrypt(text, word))

if __name__ == '__main__':
    main()
