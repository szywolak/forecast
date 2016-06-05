package com.weather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping(value="/user_page/{userName}", method= RequestMethod.GET)
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model, @PathVariable String userName) throws IOException {
        execute execute = new execute();
        List<WeatherEntity> weatherEntities = execute.selectFrom(userName);// pobieram dane
        model.addAttribute("weatherEntities", weatherEntities); // wysylam do strony

        return "user_page";
    }

}