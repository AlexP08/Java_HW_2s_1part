package com.example.Trains.repository;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.Trains.model.Route;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Репозиторий рейсов
 */
@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findAllByDepCityIdAndArrCityId(Long depCity, Long arrCity);
    List<Route> findAllByArrCityId(Long arrCity);
    List<Route> findAllByDepCityId(Long arrCity);

    List<Route> findAllByDepCityIdAndArrCityIdEquals(Long depCityId, Long arrCityId);
    List<Route> findAllByDepCityIdEquals(Long depCityId);
    List<Route> findAllByArrCityIdEquals(Long arrCityId);
    List<Route> findAllByDepCityIdAndArrCityIdAndDateDepEquals(Long depCityId, Long arrCityId, LocalDate depDate);
    List<Route> findAllByDepStationNameInAndArrStationNameInAndDateDepEquals(Collection<String> depCity_name, Collection<String> arrCity_name, LocalDate dateDep);

    @Query(value = "SELECT * FROM Route WHERE TO_CHAR(date_dep, 'YYYY-mm-dd') LIKE :year%", nativeQuery = true)
    List<Route> findAllByDateDepIsLike(@Param("year") String date);

    @Query(value = "SELECT COUNT(*) FROM Route WHERE TO_CHAR(date_dep, 'YYYY-mm-dd') LIKE :year%", nativeQuery = true)
    Integer findCountOfTrainsByDateDepIsLike(@Param("year") String date);
}
