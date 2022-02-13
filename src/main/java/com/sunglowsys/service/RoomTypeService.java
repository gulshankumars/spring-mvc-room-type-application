package com.sunglowsys.service;

import com.sunglowsys.domain.RoomType;

import java.util.List;

public interface RoomTypeService {

    RoomType save(RoomType roomType) ;

    RoomType update(RoomType roomType, Long id);

    RoomType  findById(Long id);

    List<RoomType> findAll() ;

    void delete(Long id) ;
}
