package org.launchcode.capstoneproject.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Demo")
public class DemoController {

    // Setting up my initial controller. This will handle documents for the archive.
    @RequestMapping(value="A")
    @ResponseBody
    public String first(HttpServletRequest request) {

        String name = request.getParameter("name");

        if (name == null) {
            name = "Patrick";
        }

        return "This is my first document controller. My name is " + name;
    }

    // This handler sends a get request & presents an inline html form
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {

        String html = "<form method='post' >" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet Me!' /" +
                "</form>";

        return html;
    }

    // This posts the hello message after enter entering a name n2 the form
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {

        String name = request.getParameter("name");

        return "Hello " + name + ". Your Eyez Shine Like Shimmering Skies ~";

    }

    // This handler demos how2 use a url segment with a local variable
    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {

        return "Hello " + name;

    }


    // This handler demos a redirect from /Document/B to -> /Document/A
    @RequestMapping(value="B")
    public String second() {

        return "redirect:/Demo/A";


    }
}
