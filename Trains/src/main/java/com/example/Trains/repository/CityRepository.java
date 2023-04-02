package com.example.Trains.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Trains.model.City;


/**
 * Репозиторий городов
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByNameEquals(String name);
}