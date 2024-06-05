package com.codegym.module4finaltest.service;

import com.codegym.module4finaltest.model.City;

import java.util.List;

public interface CityService extends IGenerateService<City>{
    List<City> findByNameContaining(String name);
}
