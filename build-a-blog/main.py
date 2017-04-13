import os
import webapp2
import jinja2 #Jinja2 is not automatically in here. Have to add it in app.yaml.
import cgi
from google.appengine.ext import db

#Need to create errors
#Need: Front page that lists entries (through the first 5). Route: /blog
#Need: Page with a form to submit new entries. Route: /newpost
#Permalink page for entries
#Ask about the blog id syntax in class.

template_dir = os.path.join(os.path.dirname(__file__), "templates") #Jinja is for template rendering
jinja_env = jinja2.Environment(loader = jinja2.FileSystemLoader(template_dir))

class Post(db.Model): #THIS IS OUR DATABASE. Our database is named Post.
    title = db.StringProperty(required = True)
    content = db.TextProperty(required = True)
    created = db.DateTimeProperty(auto_now_add = True)

class Handler(webapp2.RequestHandler):
    def get(self):
        t = jinja_env.get_template("front.html")
        content = t.render()#title_error = self.request.get("title_error"), #we're grabbing this from the post function
                            #blog_error = self.request.get("blog_error")) #same thing here

        #title = self.request.get("title") #This is from our HTML file (our template). We get it from input name = title.
        #blog = self.request.get("blog") #This is from our HTML file (our template). We get it from textarea name = blog.

#        if not title:
#            self.redirect("/?title_error = Please enter a title")

#        elif not blog:
#            self.redirect("/blog_error = Please enter a blog post")

        self.response.write(content)

class BlogFront(Handler):
    def get(self):
        blogs = db.GqlQuery("SELECT * FROM Post ORDER BY created DESC LIMIT 5") #Post is referring to the Post class. I need to actually WRITE this somewhere.


class ViewPostHandler(webapp2.RequestHandler):
    def get(self, id):
        self.response.write()

        blog = Post.get_by_id(int(blog_id))#Retrieves the blog entity whose id is blog_id
        t = jinja_env.get_template("viewpost.html") #Renders (a.k.a displays) the viewpost template
        content = t.render(title = title, blog = blog) #We are making it so that we are rendering and displaying the parameters we defined in this instance of the template.

                #blog.put() #Stores the model instance in the database
        self.response.write(content)


app = webapp2.WSGIApplication([
    ('/newpost', Handler)
], debug=True)
