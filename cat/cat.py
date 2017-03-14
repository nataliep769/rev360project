#verbs are going to become methods
#A cat has-a

class Cat:

    def __init__(self, color, name, isMale, meow):
        self.color = color
        self.name = name
        self.isMale = isMale
        self.meow = meow
        self.age = 0 #set to be a constant value. Every cat created will start with an age of 0.

    def sleep(self, duration):
        print(self.name + " slept for " + str(duration) + " minutes.")

    def getOlder(self):
        self.age += 1 #every time this method is used, the cat will get one year older
                    #we don't have to return self.age
    def makeMeow(self):
        print(self.makeMeow)

    def getAge(self):
        return self.age

    def getName(self):
        return self.name

    def setName(self, newName):
        self.name = newName

franklin = Cat("Orange", "Franklin", True, "MROOOOW")
franklin.sleep(60)
franklin.makeMeow()

sally = Cat("Tortoise shell", "Sally", False, "mew")
    #in charge of making sure all the state variables have some kind of a value

#Tail length - Integer or float
#Color - string
#Fur/fur length - Integer or float
#Smell - string
#name - string
#Breed - string
#number of legs - Integer
#isMale - boolean
#meow - string
#age - integer

#Can-dos
#jump(height)
#sleep(duration)
#run(distance, angle)
#hunt(prey)
#play(toy)
#purr()
#meow()
#position - point. A point is a type; it's a user-defined type.
#run
