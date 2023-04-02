package com.example.Trains.service;

import org.springframework.data.domain.Pageable;
import com.example.Trains.model.Route;

import java.util.List;

public interface RouteService {

    static Route save(Route route) {
        return route;
    }

    static Long delete(Long id) {
        return id;
    }

    static Long update(Long id, Route route) {
        return id;
    }

    static Long getRouteById(Long id) {
        return id;
    }

    static Pageable getAll(Pageable pageable) {
        return pageable;
    }

    List<Route> findAllByDepStationId(Long id);

    List<Route> findAllByArrStationId(Long id);

}