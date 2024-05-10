package com.codegym.agoda.service.impl;

import com.codegym.agoda.model.Room;
import com.codegym.agoda.model.TypeRoom;
import com.codegym.agoda.repository.ITypeRoomRepo;
import com.codegym.agoda.service.ITypeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TypeRoomService implements ITypeRoomService {
    @Autowired
    private ITypeRoomRepo iTypeRoomRepo;
    @Override
    public Iterable<Room> findAll() {
        return null;
    }

    @Override
    public Optional<Room> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Room save(Room room) {
        return null;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public List<TypeRoom> findAllType() {
        return iTypeRoomRepo.findAllType();
    }
}
