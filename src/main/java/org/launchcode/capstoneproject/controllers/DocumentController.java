package org.launchcode.capstoneproject.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("document")
public class DocumentController {

    // ArrayList to hold a String giving the bare bones of a document
   static  ArrayList<String> documents = new ArrayList<>();

    // Request path is /document & returns an h1 from index.html, using model.addAttribute to dynamically change title.
    @RequestMapping(value="")
    public String index(Model model) {


        // using model.addAttribute to take the name of the ArrayList and link it to the model
        // enabling us to loop over it to show an unordered list of Strings in the view
        model.addAttribute("documents", documents);
        model.addAttribute("title", "Creative Documents");

        return "document/index";
    }

    @RequestMapping(value = "add",  method = RequestMethod.GET)
    public String displayAddDocumentForm(Model model) {

        model.addAttribute("title", "Add Document");

        return "document/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddDocumentForm(@RequestParam String documentName) {
        documents.add(documentName);

        // Redirect to /document
        return "redirect:";


    }
}
