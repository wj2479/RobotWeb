package com.wj.bike.mapper;

import com.wj.bike.bean.Bike;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BikeMapper {
    void save(Bike bike);
}
