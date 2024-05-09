package com.codegym.agoda.controller;

import com.codegym.agoda.dto.HouseSpec;
import com.codegym.agoda.dto.PaginateRequest;
import com.codegym.agoda.model.House;
import com.codegym.agoda.service.impl.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController("apiHouseController")
@RequestMapping("/api/house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @Value("${file-upload}")
    private String fileUpload;

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


    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("files") MultipartFile[] files) {
        try {
            for (MultipartFile file : files) {
                // Lưu trữ từng file vào thư mục cụ thể
                file.transferTo(new File(fileUpload + file.getOriginalFilename()));
            }
            return ResponseEntity.ok("Files uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload files");
        }
    }

}
