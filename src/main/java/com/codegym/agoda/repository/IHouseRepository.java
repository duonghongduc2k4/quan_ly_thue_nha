package com.codegym.agoda.repository;

import com.codegym.agoda.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IHouseRepository extends JpaRepository<House,Integer>, JpaSpecificationExecutor<House> {
}
