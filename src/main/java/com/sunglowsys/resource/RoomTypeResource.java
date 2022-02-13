package com.sunglowsys.resource;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.service.RoomTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomTypeResource {

    private final Logger log = LoggerFactory.getLogger(RoomTypeResource.class);

    private RoomTypeService roomTypeService;

    public RoomTypeResource(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @PostMapping("/roomTypes")
    public ResponseEntity<?> createRoomType(@RequestBody RoomType roomType) throws URISyntaxException {
        log.debug("REST request to sava roomType : {}" ,roomType);
        RoomType result = roomTypeService.save(roomType);
        return ResponseEntity.
                ok().
                body(" RoomType is created successfully: " + result);
    }

    @PutMapping("/roomType")
    public ResponseEntity<?> updateRoomType(@RequestBody RoomType roomType){
        log.debug("REST request to update roomType : {}" ,roomType);
        RoomType result = roomTypeService.save(roomType);
        return ResponseEntity
                .ok()
                .body("RoomTYpe is updated successfully:" + result);
    }
    @GetMapping("/roomTypes")
    public ResponseEntity<?> findAllRoomType(){
        log.debug("REST request to find all RoomType : {}" );
        List<RoomType> result = roomTypeService.findAll();
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/roomType/{id}")
    public ResponseEntity<?> findRoomTypeById(@PathVariable Long id){
        log.debug("REST request to findById roomType : {}" ,id);
        RoomType result = roomTypeService.findById(id);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @DeleteMapping("/roomType/{id}")
    public ResponseEntity<Void>  DeleteRoomType(@PathVariable Long id){
        log.debug("REST request to delete RoomType : {}", id);
        roomTypeService.delete(id);
         return ResponseEntity
                 .noContent()
                 .build();
    }



}
