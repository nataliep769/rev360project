import string

def alphabet_position(letter):
    letter = letter.lower()
    position = string.ascii_lowercase.index(letter)
    return position

def rotate_character(char, rot):
    if char not in string.ascii_letters:
        new_character = char
    elif char in string.ascii_lowercase:
        position = alphabet_position(char)
        new_index = (position + int(rot)) % 26
        new_character = string.ascii_lowercase[new_index]
    else:
        position = alphabet_position(char)
        new_index = (position + int(rot)) % 26
        new_character = string.ascii_uppercase[new_index]
    return new_character
