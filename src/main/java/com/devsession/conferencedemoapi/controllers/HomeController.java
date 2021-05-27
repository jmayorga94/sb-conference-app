package com.devsession.conferencedemoapi.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    @ApiOperation("Get app version ")
    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    public Map getVersion(){
        Map map = new HashMap<String,String>();
        map.put("app-version",appVersion);

        return map;
    }
}
