package com.codegym.module4finaltest.service.impl;

import com.codegym.module4finaltest.model.Country;
import com.codegym.module4finaltest.repository.CountryRepository;
import com.codegym.module4finaltest.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceimpl implements CountryService {
    @Autowired
    private CountryRepository countryRep;
    @Override
    public List<Country> findByCountryNameContaining(String name) {
        return countryRep.findByCountryNameContaining(name);
    }

    @Override
    public List<Country> findAll() {
        return countryRep.findAll();
    }

    @Override
    public Country findById(Long id) {
        Optional<Country> countryOptional = countryRep.findById(id);
        return countryOptional.get();
    }

    @Override
    public void save(Country country) {
        countryRep.save(country);
    }

    @Override
    public void remove(Long id) {
        countryRep.deleteById(id);
    }
}
