from post import Post

class VideoPost(Post):
    def __init__(self, title, author, url):
        super().__init__(title, author, None) #we are calling the constructor here
        self.video_url = url
        self.plays = 0

    def play(self):
        self.plays += 1

    def __str__(self):
        return "Title: " + self.title + " Author" + self.author + " Url: " + self.video_url

vid_post = VideoPost("Little Scream - Love As a Weapon", "Chris Bay", "https://youtu.be/Tq4Vw4MB6eA")
vid_post.play()
vid_post.play()

print(vid_post)
