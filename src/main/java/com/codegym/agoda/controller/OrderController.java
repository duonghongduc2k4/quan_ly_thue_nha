package com.codegym.agoda.controller;

import com.codegym.agoda.dto.OrderDto;
import com.codegym.agoda.model.HouseAccount;
import com.codegym.agoda.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController("apiOrderController")
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping()
    public ResponseEntity<HouseAccount> saveOrder(@RequestBody OrderDto orderDto) throws ParseException {
        return new ResponseEntity<>(orderService.saveOrder(orderDto), HttpStatus.OK);
    }
}
