package com.codegym.agoda.repository;

import com.codegym.agoda.model.HouseAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<HouseAccount,Integer> {
}
