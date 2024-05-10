package com.codegym.agoda.service;

import com.codegym.agoda.model.Room;
import com.codegym.agoda.model.TypeRoom;
import com.codegym.agoda.repository.IRoomRepo;

import java.util.List;

public interface ITypeRoomService extends IGenerateService<Room> {
    List<TypeRoom> findAllType();


}
