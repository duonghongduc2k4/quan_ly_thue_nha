package com.codegym.agoda.repository;

import com.codegym.agoda.model.House;
import com.codegym.agoda.model.TypeRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITypeRoomRepo extends JpaRepository<TypeRoom,Integer>, JpaSpecificationExecutor<TypeRoom> {
//    @Query("select  t.name  from  Room as r inner join TypeRoom as t on r.id=t.room.id")
//    List<TypeRoom> findAllType();
 }
