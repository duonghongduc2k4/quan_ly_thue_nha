package com.codegym.agoda.service;

import com.codegym.agoda.dto.PaginateRequest;
import com.codegym.agoda.model.House;
import org.springframework.data.domain.Page;

public interface IHouseService extends IGenerateService<House>{
    Page<House> findAll(House house, PaginateRequest paginateRequest);
}
