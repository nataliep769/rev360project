from post import Post

class ImagePost(Post):
    def __init__(self, title, author, file_name):
        super().__init__(title, author, None) #we are calling the constructor here
        self.url = url
        self.file_names = 0

    def file_name(self):
        self.file_names += 1

pic_post = ImagePost("Cats in space", "Crystal Martin", "spacecats.gif")
print(pic_post)
