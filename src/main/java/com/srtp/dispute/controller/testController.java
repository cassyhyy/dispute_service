package com.srtp.dispute.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/test/get")
public class testController {
    @RequestMapping(method = RequestMethod.GET)
    public String sayWorld() {
        return "Hello ";
    }
}