package com.weather;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;

@RequestMapping("/user_page")
public class Ctrl {

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Kot> get(@PathVariable("id") String id) throws IOException {
        execute execute = new execute();
        List an = execute.selectFrom(id);
        return new ResponseEntity<an>(an, new HttpHeaders(), HttpStatus.OK);
    }
}