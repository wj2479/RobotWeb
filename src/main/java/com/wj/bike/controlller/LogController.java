package com.wj.bike.controlller;

import com.wj.bike.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping("/log/ready")
    @ResponseBody
    public String saveLog(@RequestBody String log) {
        logService.saveLog(log);
        return "success";
    }
}
