package com.example.Trains.controller;

import com.example.Trains.model.Route;
import com.example.Trains.service.RouteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер рейсов

 */
@RestController
public class RouteController {


    /**
     * Контроллер GET запроса по ссылке "/routes"

     */
    @GetMapping("/Routes")
    public Page<Route> getAllTrains(Pageable pageable) {
        return (Page<Route>) RouteService.getAll(pageable);
    }

    @GetMapping("/routes/{trainId}")
    public Long getTrainById(@PathVariable Long trainId) {
        return RouteService.getRouteById(trainId);
    }


    /**
     * Контроллер POST запроса по ссылке "/routes"
     */
    @PostMapping("/routes")
    public Route addRoute( @RequestBody Route route) {
        return RouteService.save(route);
    }

    /**
     * Контроллер PUT запроса по ссылке "/routes/{routId}"
     */
    @PutMapping("/routss/{routId}")
    public Long updateRoute(@PathVariable Long routeId,
                            @RequestBody Route route) {
        return RouteService.update(routeId, route);
    }

    /**
     * Контроллер DELETE запроса по ссылке "/routes/{routeId}"
     */
    @DeleteMapping("/routes/{routeId}")
    public Long deleteRoute(@PathVariable Long routeId) {
        return RouteService.delete(routeId);
    }
}
