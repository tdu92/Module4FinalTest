package com.codegym.module4finaltest.controller;

import com.codegym.module4finaltest.model.City;
import com.codegym.module4finaltest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService citySer;

    @GetMapping("")
    public ResponseEntity<List<City>> getAll() {
        List<City> cities = citySer.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody City city) {
        citySer.save(city);
        String message = "Add Success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody City city) {
        city.setCityId(id);
        citySer.save(city);
        String message = "Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        citySer.remove(id);
        String message="Delete success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<City> findById(@PathVariable Long id){
        City city = citySer.findById(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<City>> search(@Param("name")String name){
        List<City> list = citySer.findByNameContaining(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}