package com.codegym.agoda.service.impl;

import com.codegym.agoda.dto.HouseSpec;
import com.codegym.agoda.dto.PaginateRequest;
import com.codegym.agoda.model.House;
import com.codegym.agoda.repository.IHouseRepository;
import com.codegym.agoda.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseService  implements IHouseService {
    @Autowired
    private IHouseRepository iHouseRepository;
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
        return iHouseRepository.findAll(specification,pageable);
    }
}
