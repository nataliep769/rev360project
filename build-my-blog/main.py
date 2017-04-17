import os
import webapp2
import jinja2 #Jinja2 is not automatically in here; I have to add it in app.yaml. Jinja is for template rendering.
import cgi
from google.appengine.ext import db
#Permalink page for entries
#"Get" and "post" are built-in methods (I think they come from webapp2?)
#Is Google App Engine where the database is located?
#Think about renaming text_body and renaming content to be different so as not to confuse the database property with the name of a variable

template_dir = os.path.join(os.path.dirname(__file__), "templates")
jinja_env = jinja2.Environment(loader = jinja2.FileSystemLoader(template_dir))

class Handler(webapp2.RequestHandler):
    def render_str(self, template, **params):
        t = jinja_env.get_template(template)
        return t.render(params)

    def render(self, template, **kw):
        self.response.write(self.render_str(template, **kw))

#THE DATABASE
class Post(db.Model):
    title = db.StringProperty(required = False)
    text_body = db.TextProperty(required = False)
    created = db.DateTimeProperty(auto_now_add = True)
#Are these properties global? Are they properties or variables?

class NewPost(Handler):
    def render_page(self, title = "", text_body = "", title_error ="", blog_error = ""): #We are passing in empty string to serve as the inital values that are rendered on the page.
        self.render("front.html", title = title, text_body = text_body, title_error = title_error, blog_error = blog_error)

        #Are these all the variables we will ultimately have to render?
        #Is this setting the HTML variables equal to the Python variables?

    def get(self):
        self.render_page()

    def post(self):

        title = self.request.get("title") #This is from the form in the HTML file (a template). We get it from input name = title.
        text_body = self.request.get("text_body") #This is also from the form in the HTML file (a template). We get it from extarea name = text_body.

        title_error = ""
        blog_error = ""

        #ERRORS
        if title == "":
            title_error = "Please enter a title"
            self.render_page(title, text_body, title_error, blog_error)

        elif text_body == "":
            blog_error = "Please enter a blog post"
            self.render_page(title, text_body, title_error, blog_error)

        else:
            b = Post(title = title, text_body = text_body)
            b.put()
            self.redirect("/blog")

class BlogsListedHandler(Handler):
    def render_blogs_listed(self, blogs = ""): #do not need title = "" or blog_content = "" in this statement
        blogs = db.GqlQuery("SELECT * FROM Post ORDER BY created DESC LIMIT 5") #Eliminated "ORDER BY created DESC" for this to work and then put it back in. Had I forgotten a quote or parentheses?
        self.render("blogslisted.html", blogs = blogs)

    def get(self): #Defining this made me stop getting a 405 GET method error
        self.render_blogs_listed()

class ViewPostHandler(webapp2.RequestHandler):
    def get(self, id):
        pass #replace this with some code to handle the request

        blog_id = self.request.get(#some value)

        watched_movie = Post.get_by_id( int(blog_id) )

app = webapp2.WSGIApplication([
    ('/', NewPost),
    ('/blog', BlogsListedHandler),
    webapp2.Route('/blog/<id:\d+>', ViewPostHandler)
], debug=True)
