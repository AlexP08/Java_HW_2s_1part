package com.example.Trains.controller;

import com.example.Trains.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.example.Trains.model.City;


/**
 * Контроллер городов
 */
@RestController
public class CityController {


    @GetMapping("/citys")
    public Page<City> getAllStations(Pageable pageable){
        return CityService.getAll(pageable);
    }

    /**
     * Контроллер GET запроса по ссылке "/citys/{cityId}"
     */
    @GetMapping("/citys/{cityId}")
    public Long getStationById(@PathVariable Long cityId){
        return CityService.getStationById(cityId);
    }


    /**
     * Контроллер PUT запроса по ссылке "/city/{cityId}"
     */
    @PutMapping("/city/{cityId}")
    public Long updateCity(@PathVariable Long cityId,
                           @RequestBody City city) {
        return CityService.update(cityId, city);
    }

    /**
     * Контроллер DELETE запроса по ссылке "/city/{cityId}"
     */
    @DeleteMapping("/city/{cityId}")
    public Long deleteCity(@PathVariable Long cityId) {
        return CityService.delete(cityId);
    }
}