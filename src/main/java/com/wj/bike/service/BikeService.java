package com.wj.bike.service;


import com.wj.bike.bean.Bike;
import org.springframework.data.geo.GeoResults;

import java.util.List;

public interface BikeService {

    void saveBike(Bike bike);

    List<Bike> findAll();

    void insert(String info);

    GeoResults<Bike> findNear(double lng, double lat);
}
