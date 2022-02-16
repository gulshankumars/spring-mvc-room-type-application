package com.sunglowsys.service;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.repository.RoomTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
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
    public Optional<RoomType> findById(Long id) {
        log.debug("Request to get RoomTypes : {}", id);
        return roomTypeRepository.findById(id);
    }

    @Override
    public Page<RoomType> findAll(Pageable pageable) {
        log.debug("Request to get all RoomTypes : {}", pageable.toString());
        return roomTypeRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete RoomType :{}", id);
        roomTypeRepository.deleteById(id);

    }
}
