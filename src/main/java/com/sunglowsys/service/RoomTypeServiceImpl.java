package com.sunglowsys.service;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.repository.RoomTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService{

    private final Logger log = LoggerFactory.getLogger(RoomTypeService.class);

    private final  RoomTypeRepository roomTypeRepository ;

    public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    @Override
    public RoomType save(RoomType roomType) {
        log.debug("Request to savaRoomType : {}", roomType);
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType update(RoomType roomType, Long id) {
        log.debug("Request to update RoomType : {}", roomType);
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType findById(Long id) {
        log.debug("Request to get RoomTypes : {}", id);
        return roomTypeRepository.findById(id).get();
    }

    @Override
    public List<RoomType> findAll() {
        log.debug("Request to get all RoomTypes");
        return roomTypeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete RoomType :{}", id);
        roomTypeRepository.deleteById(id);

    }
}
