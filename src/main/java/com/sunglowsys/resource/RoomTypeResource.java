package com.sunglowsys.resource;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.resource.util.BadRequestException;
import com.sunglowsys.service.RoomTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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
        if (roomType.getId() != null){
            throw new BadRequestException("Id should be null in created api call");
        }
        RoomType result = roomTypeService.save(roomType);
        return ResponseEntity.
                ok().
                body(result);
    }

    @PutMapping("/roomType")
    public ResponseEntity<RoomType> updateRoomType(@RequestBody RoomType roomType) throws URISyntaxException{
        log.debug("REST request to update roomType : {}" ,roomType);
        if (roomType.getId() == null){
            throw new BadRequestException("Id should not be null in updated api call");
        }
        RoomType result = roomTypeService.save(roomType);
        return ResponseEntity
                .ok()
                .body(result);
    }
    @GetMapping("/roomTypes")
    public ResponseEntity<List<RoomType>> findAllRoomType(@RequestBody Pageable pageable){
        log.debug("REST request to find all RoomType : {}", pageable.toString() );
        Page<RoomType> result = roomTypeService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());
    }

    @GetMapping("/roomType/{id}")
    public ResponseEntity<RoomType> findRoomType(@PathVariable Long id){
        log.debug("REST request to findById roomType : {}" ,id);
       Optional<RoomType> result = roomTypeService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }

    @DeleteMapping("/roomType/{id}")
    public ResponseEntity<Void>  DeleteRoomType(@PathVariable Long id){
        log.debug("REST request to delete RoomType : {}", id);
        roomTypeService.delete(id);
         return ResponseEntity
                 .ok()
                 .build();
    }



}
