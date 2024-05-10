package com.codegym.agoda.dto;

import com.codegym.agoda.model.House;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class HouseSpec implements Specification<House> {
    private House house;

    public HouseSpec(House house) {
        this.house = house;
    }

    @Override
    public Predicate toPredicate(Root<House> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        // chứa danh sách các điều kiện
        List<Predicate> predicateList = new ArrayList<Predicate>();

        if (house.getName() != null) {
            predicateList.add(criteriaBuilder.like(root.get("name"),"%" + house.getName() + "%"));
        }

        if (!predicateList.isEmpty()) {
            query.where(predicateList.toArray(new Predicate[0]));
        }
        return query.getRestriction();
    }
}
