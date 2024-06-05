package com.codegym.module4finaltest.repository;

import com.codegym.module4finaltest.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByCountryNameContaining(String name);
}
