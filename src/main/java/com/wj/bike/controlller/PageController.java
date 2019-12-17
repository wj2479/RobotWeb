package com.wj.bike.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class PageController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/host")
    @ResponseBody
    public String host() {
        String host = "Unknown";
        try {
            host = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
        }
        return host;
    }
}
