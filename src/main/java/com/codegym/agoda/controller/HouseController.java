package com.codegym.agoda.controller;

import com.codegym.agoda.dto.HouseDto;
import com.codegym.agoda.dto.HouseSpec;
import com.codegym.agoda.dto.PaginateRequest;
import com.codegym.agoda.model.House;
import com.codegym.agoda.model.Room;
import com.codegym.agoda.model.TypeRoom;
import com.codegym.agoda.repository.ITypeRoomRepo;
import com.codegym.agoda.service.impl.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController("apiHouseController")
@RequestMapping("/api/house")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private ITypeRoomRepo typeRoomRepo;

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleException(Exception e){
        return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})


    @GetMapping
    public ResponseEntity<List<House>> listHouse(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size
    ) {
        House house = new House();
        house.setName(name);
        PaginateRequest paginateRequest = new PaginateRequest(page, size);
        Page<House> pages = houseService.findAll(house, paginateRequest);
        return new ResponseEntity<>(pages.getContent(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<House> findHouseById(@PathVariable int id) {
        Optional<House> customerOptional = houseService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    private ResponseEntity<House> save(@ModelAttribute HouseDto houseDto) throws IOException {
        House house = houseService.saveHouse(houseDto);
        return new ResponseEntity<>(house, HttpStatus.CREATED);
    }


}
