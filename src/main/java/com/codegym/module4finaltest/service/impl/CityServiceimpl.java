package com.codegym.module4finaltest.service.impl;

import com.codegym.module4finaltest.model.City;
import com.codegym.module4finaltest.repository.CityRepository;
import com.codegym.module4finaltest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceimpl implements CityService {
    @Autowired
    private CityRepository cityRep;

    @Override
    public List<City> findByNameContaining(String name) {
        return cityRep.findByCityNameContaining(name);
    }

    @Override
    public List<City> findAll() {
        return cityRep.findAll();
    }

    @Override
    public City findById(Long id) {
        Optional<City> cityOptional = cityRep.findById(id);
        return cityOptional.get();
    }

    @Override
    public void save(City city) {
        cityRep.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRep.deleteById(id);
    }
}
