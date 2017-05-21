package launchcode.org.hellowinter.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static launchcode.org.hellowinter.controllers.HelloController.createMessage;

/**
 * Created by Natalie on 5/13/2017.
 */

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");

        if (name == null) {
            name = "World";
        }

        return "Hello " + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {

        String html = "<form method='post'>" + "<input type='text' name='name'/>" + "<select name='language'>" +
                "<option value='French'>French</option><option value='Spanish'>Spanish</option><option value='German'>German</option>" + "</select>"
                + "<input type='Submit' value='Greet me!'/>" + "</form>";

        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {

        String name = request.getParameter("name");
        String language = request.getParameter("language");
        return "Hello" + name;

        if(name == null) {
            name = "World";
        }
        if(language == null) {
            language == "English";
        }

        return createMessage(name, language);
    }

    @RequestMapping(value ="hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello" + name;
    }

    public static createMessage(String name, String language) {
        if(language.equals("English")) {
            return "Hello, " + name;
        }

        if(language.equals("Spanish")) {
            return "Ola, " + name;
        }

        return "Bonjour, " + name;
    }

    @RequestMapping(value = "goodbye")
    @ResponseBody
    public String goodbye () {
        return "redirect:/";

    }
}