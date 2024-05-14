package com.codegym.agoda.service.impl;

import com.codegym.agoda.dto.HouseDto;
import com.codegym.agoda.dto.HouseSpec;
import com.codegym.agoda.dto.PaginateRequest;
import com.codegym.agoda.dto.RoomDto;
import com.codegym.agoda.model.House;
import com.codegym.agoda.model.Image;
import com.codegym.agoda.model.Room;
import com.codegym.agoda.model.TypeRoom;
import com.codegym.agoda.repository.IHouseRepository;
import com.codegym.agoda.repository.IImageRepo;
import com.codegym.agoda.repository.IRoomRepo;
import com.codegym.agoda.repository.ITypeRoomRepo;
import com.codegym.agoda.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class HouseService implements IHouseService {
    @Autowired
    private IHouseRepository iHouseRepository;
    @Autowired
    private IRoomRepo iRoomRepo;
    @Autowired
    private ITypeRoomRepo iTypeRoomRepo;
    @Autowired
    private IImageRepo iImageRepo;

    @Value("${file-upload}")
    private String fileUpload;

    @Override
    public Iterable<House> findAll() {
        return iHouseRepository.findAll();
    }

    @Override
    public Optional<House> findById(int id) {
        return iHouseRepository.findById(id);
    }

    @Override
    public House save(House house) {
        return iHouseRepository.save(house);
    }

    @Override
    public void delete(int id) {
        iHouseRepository.deleteById(id);
    }

    @Override
    public Page<House> findAll(House house, PaginateRequest paginateRequest) {
        Specification<House> specification = new HouseSpec(house);
        Pageable pageable = PageRequest.of(paginateRequest.getPage(), paginateRequest.getSize());
        return iHouseRepository.findAll(specification, pageable);
    }

    @Override
    public House saveHouse(HouseDto houseDto) throws IOException {
        //them nha
        House house = iHouseRepository.save(houseDto.toHouse());

        //them phong
        for (RoomDto roomDto : houseDto.getRooms()) {
            Room room = new Room();
            if (roomDto.getId() != 0) {
                room.setId(iTypeRoomRepo.findById(roomDto.getTypeId()).get().getId());
            }
            room.setName(roomDto.getName());
//            lấy id thằng typeRoom
            room.setTypeRoom(iTypeRoomRepo.findById(roomDto.getTypeId()).get());
            room.setHouse(house);
            iRoomRepo.save(room);
        }
        if (houseDto.getImage() == null) {
            Image image = new Image();
            image.setNameImage("img/default.jpg");
            image.setHouse(house);
            iImageRepo.save(image);
        }
        MultipartFile multipartFile = houseDto.getImage();
        String filename = multipartFile.getOriginalFilename();
        FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + filename));
        Image image = new Image();
        image.setNameImage("img/" + filename);
        if (image.getId() == 0) {
            image.setHouse(house);
        }
        image.setId(houseDto.getId());
        iImageRepo.save(image);
        return house;
    }


}
