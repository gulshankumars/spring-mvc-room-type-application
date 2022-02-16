package com.sunglowsys.service;

import com.sunglowsys.domain.RoomType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RoomTypeService {

    RoomType save(RoomType roomType) ;

    RoomType update(RoomType roomType, Long id);

    Optional<RoomType>  findById(Long id);

    Page<RoomType> findAll(Pageable pageable) ;

    void delete(Long id) ;
}
