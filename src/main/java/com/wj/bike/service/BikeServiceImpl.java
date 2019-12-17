package com.wj.bike.service;

import com.alibaba.fastjson.JSONObject;
import com.wj.bike.bean.Bike;
import com.wj.bike.mapper.BikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 加入声明 事务  对于出错的逻辑可以进行回滚
 */
@Transactional
@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private BikeMapper bikeMapper;

    @Override
    public void saveBike(Bike bike) {
        bikeMapper.save(bike);
    }

    @Override
    public List<Bike> findAll() {
        return null;
    }


    @Override
    public void insert(String info) {
        Bike bike = JSONObject.parseObject(info, Bike.class);
        System.out.println("info->" + bike);
        mongoTemplate.save(bike);
    }

    @Override
    public GeoResults<Bike> findNear(double lng, double lat) {
        System.out.println("info->" + lng + "  " + lat);
        NearQuery nearQuery = NearQuery.near(lng, lat, Metrics.KILOMETERS);
        nearQuery.maxDistance(0.5).limit(10);
        GeoResults<Bike> geoResults = mongoTemplate.geoNear(nearQuery, Bike.class);
        return geoResults;
    }
}
