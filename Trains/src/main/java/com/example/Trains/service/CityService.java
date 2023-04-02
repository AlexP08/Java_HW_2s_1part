package com.example.Trains.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.Trains.model.City;

import java.util.List;

public interface CityService {

    City save(City station, String cityName);

    static Long delete(Long id) {
        return id;
    }

    static Long update(Long id, City city) {
        return id;
    }

    static Long getStationById(Long id) {
        return id;
    }

    static Page<City> getAll(Pageable pageable) {
        return (Page<City>) pageable;
    }

    List<City> getAllByDepartingRoute(Long id);

    List<City> getAllByArrivingRoute(Long id);

}
