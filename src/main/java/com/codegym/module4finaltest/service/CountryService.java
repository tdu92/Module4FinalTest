package com.codegym.module4finaltest.service;

import com.codegym.module4finaltest.model.Country;

import java.util.List;

public interface CountryService extends IGenerateService<Country>{
    List<Country> findByCountryNameContaining (String name);
}
