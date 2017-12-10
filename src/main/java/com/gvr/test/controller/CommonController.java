package com.gvr.test.controller;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.gvr.test.model.Response;

@RestController
@RequestMapping("/v1/gvr")
public class CommonController {

    @RequestMapping(method = RequestMethod.GET,value="/currentTime", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCurrentTime() {
        Response response = new Response(ISO8601Utils.format(new Date()));
        return ResponseEntity.ok(response);
    }
    
    @RequestMapping(method = RequestMethod.GET,value="/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> test() {
        
        return ResponseEntity.ok("testing");
    }
    
}
