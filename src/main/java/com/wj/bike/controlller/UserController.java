package com.wj.bike.controlller;

import com.wj.bike.bean.User;
import com.wj.bike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/reg")
    @ResponseBody
    public String reg(User user) {
        System.out.println(user);
        userService.register(user);
        return "success";
    }

    @PostMapping("/deposit")
    @ResponseBody
    public String deposit(User user) {
        System.out.println(user);
        userService.deposit(user);
        return "success";
    }

    @PostMapping("/identify")
    @ResponseBody
    public String identify(User user) {
        userService.identify(user);
        return "success";
    }

    @PostMapping("/recharge")
    @ResponseBody
    public boolean recharge(@RequestBody String params) {
        return userService.recharge(params);
    }
}
