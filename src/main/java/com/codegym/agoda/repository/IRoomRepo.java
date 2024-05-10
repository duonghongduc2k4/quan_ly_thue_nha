package com.codegym.agoda.repository;

import com.codegym.agoda.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepo extends JpaRepository<Room,Integer> {
}
