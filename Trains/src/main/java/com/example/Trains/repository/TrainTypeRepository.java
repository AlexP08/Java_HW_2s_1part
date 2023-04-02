package com.example.Trains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Trains.model.TrainType;

/**
 * Репозиторий типов поезда
 */
@Repository
public interface TrainTypeRepository extends JpaRepository<TrainType, Long> {
    TrainType findByNameEquals(String name);
}
