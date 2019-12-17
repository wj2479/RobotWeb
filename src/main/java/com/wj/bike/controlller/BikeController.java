package com.wj.bike.controlller;

import com.wj.bike.bean.Bike;
import com.wj.bike.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/bike")
    @ResponseBody
    public String getBikeById(Bike bike) {
        bikeService.saveBike(bike);
        return "success";
    }

    @GetMapping("/bikes")
    @ResponseBody
    public List<Bike> findAll() {
        return bikeService.findAll();
    }

    @GetMapping("/bikenear")
    @ResponseBody
    public GeoResults<Bike> findNear(double lng, double lat) {
        return bikeService.findNear(lng, lat);
    }

    /**
     * 保存单车
     *
     * @param info
     * @return
     */
    @PostMapping("/saveBike")
    @ResponseBody
    public String saveBike(@RequestBody String info) {
        bikeService.insert(info);
        return "success";
    }

    @GetMapping("/bike_list")
    public String toList() {
        return "bike/list";
    }

//    @ResponseBody
//    public List<Bike> bikeList() {
//        return mongoTemplate.findAll(Bike.class, "bike");
//    }
}
