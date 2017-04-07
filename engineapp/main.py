import webapp2
import cgi
import re

#regex expressions

USER_RE = re.compile(r"^[a-zA-Z0-9_-]{3,20}$")
def valid_username(username):
    return USER_RE.match(username)

PASS_RE = re.compile("^.{3,20}$")
def valid_password(password):
    return PASS_RE.match(password)

EMAIL_RE = re.compile("^[\S]+@[\S]+.[\S]+$")
def valid_email(email):
    return EMAIL_RE.match(email)

#HTML boilerplate for the top of every page

page_header = """
<!DOCTYPE html>
<html>
<head>
    <title>Signup</title>
</head>
<body>
    <h1>Signup</h1>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
"""
#HTML boilerplate for the bottom of every page

page_footer = """
</body>
</html>
"""

class Index(webapp2.RequestHandler):
    def get(self):

        username_error = self.request.get("username_error")
        password_error = self.request.get("password_error")
        verify_error = self.request.get("verify_error")
        email_error = self.request.get("email_error")

        #Empty string variables for error elements
        username_error_element = ""
        password_error_element = ""
        verify_error_element = ""
        email_error_element = ""

        #Defining errors
        if username_error:
            username_error_esc= cgi.escape(username_error, quote=True) #This is the escaped text. The error text with proper escape characters.
            username_error_element = '<b class="error">' + username_error_esc + '</b>'
        else: username_error_element = ''

        if password_error:
            password_error_esc = cgi.escape(password_error, quote=True)
            password_error_element = '<b class="error">' + password_error_esc + '</b>'
        else: password_error_element = ''

        if verify_error:
            verify_error_esc = cgi.escape(verify_error, quote=True)
            verify_error_element = '<b class="error">' + verify_error_esc + '</b>'
        else: verify_error_element = ''

        if email_error:
            email_error_esc= cgi.escape(email_error, quote=True)
            email_error_element = '<b class="error">' + email_error_esc + '</b>'
        else: email_error_element = ''

        #FORMS
        username_form = """
        <form action="/" method="post">
            <label>
                <p>Username</p>
                <input type="text" name="username"/>
            </label>
        """ + username_error_element

        password_form = """
            <label>
                <p>Password</p>
                <input type="password" name="password"/>
            </label>
        """ + password_error_element

        verify_password_form = """
            <label>
                <p>Verify Password</p>
                <input type="password" name="verify_password"/>
            </label>
        """ + verify_error_element

        email_form = """
            <label>
                <p>Email (optional)</p>
                <input type="text" name="email"/>
            </label>
            <input type="submit" name="Submit"/>
        </form>
        """ + email_error_element

        content = page_header + username_form + password_form + verify_password_form + email_form + page_footer
        self.response.write(content)

    def post(self):
        #TYPES OF ERRORS
        username = self.request.get("username") #This get does not have anything to do with the GET method.
        password = self.request.get("password")
        verify_password = self.request.get("verify_password")
        email = self.request.get("email")

        #USERNAME ERROR
        if not USER_RE.match(username):
            self.redirect("/?username_error=Please enter an appropriate username")

        #PASSWORD ERRORS
        elif not PASS_RE.match(password):
            self.redirect("/?password_error=Please enter a password")

        #VERIFY PASSWORD ERROR
        elif password != verify_password:
            self.redirect("/?verify_error=Your two passwords do not match")

        #EMAIL ERROR
        elif EMAIL_RE.match(email):
            self.redirect("/?email_error=Please enter a valid email address")

        escaped_username = cgi.escape(username, quote=True) #cgi.escape() doesn't include quotes by default. Quote = true makes us escape quotes
        username_element = "<strong>" + username + "</strong>"
        content = "Welcome, " + username_element + "!"
        self.response.write(content)

app = webapp2.WSGIApplication([
    ('/', Index)
], debug=True)
