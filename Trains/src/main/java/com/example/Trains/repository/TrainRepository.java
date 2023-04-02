package com.example.Trains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Trains.model.Train;

import java.util.List;

/**
 * Репозиторий поездов
 */
@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findAllByTrainIdEquals(Long trainId);
    List<Train> findAllByTrainTypeIdEquals(Long trainType_id);
    List<Train> findAllByTrainIdAndTrainTypeIdEquals(Long train_id, Long trainType_id);
}

