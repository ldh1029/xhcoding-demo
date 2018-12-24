package com.example.demo.mapper;

import com.example.demo.model.HotelSupreme;

public interface HotelSupremeMapper {
    int deleteByPrimaryKey(String id);

    int insert(HotelSupreme record);

    int insertSelective(HotelSupreme record);

    HotelSupreme selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HotelSupreme record);

    int updateByPrimaryKey(HotelSupreme record);
}