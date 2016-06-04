package com.weather;

import org.apache.catalina.connector.Response;
import org.omg.CORBA.portable.InputStream;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/user_page")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="Worldaskodjdsdokasdosa") String name, Model model) {
        model.addAttribute("name", name);
        return "user_page";
    }

    @RequestMapping("/user_page/id")
    public String gtr (Model model) throws FileNotFoundException {
        File ob = new File("user_reports/User01.json");
        model.addAttribute(ob.toString());

        return "user_page";
    }


}