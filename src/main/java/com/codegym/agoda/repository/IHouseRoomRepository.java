package com.codegym.agoda.repository;

import com.codegym.agoda.model.HouseRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHouseRoomRepository extends JpaRepository<HouseRoom, Integer> {
}
