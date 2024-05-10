package com.codegym.agoda.service.impl;

import com.codegym.agoda.model.HouseRoom;
import com.codegym.agoda.repository.IHouseRoomRepository;
import com.codegym.agoda.service.IHouseRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseRoomService implements IHouseRoomService {
    @Autowired
    private IHouseRoomRepository iHouseRoomRepository;
    @Override
    public Iterable<HouseRoom> findAll() {
        return null;
    }

    @Override
    public Optional<HouseRoom> findById(int id) {
        return Optional.empty();
    }

    @Override
    public HouseRoom save(HouseRoom houseRoom) {
        return iHouseRoomRepository.save(houseRoom);
    }

    @Override
    public void delete(int id) {

    }
}
