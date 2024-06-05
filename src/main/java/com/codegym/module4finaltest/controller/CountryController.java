package com.codegym.module4finaltest.controller;

import com.codegym.module4finaltest.model.Country;
import com.codegym.module4finaltest.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private CountryService countrySer;

    @GetMapping("")
    public ResponseEntity<List<Country>> getAll(){
        List<Country> list = countrySer.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody Country country){
        countrySer.save(country);
        String message="Add success";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody Country country){
        country.setCountryId(id);
        countrySer.save(country);
        String message="Edit success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        countrySer.remove(id);
        String message="Delete success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
        Country country = countrySer.findById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Country>> search(@Param("name")String name){
        List<Country> list = countrySer.findByCountryNameContaining(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
