package com.codegym.module4finaltest.repository;

import com.codegym.module4finaltest.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    City findByCityName(String name);
    List<City> findByCityNameContaining(String name);
    List<City> findByAreaBetween(double from, double to);
    List<City> findByGdpBetween(double from, double to);

}
