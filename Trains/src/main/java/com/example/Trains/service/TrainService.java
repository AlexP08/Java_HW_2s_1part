package com.example.Trains.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.Trains.model.Train;

import java.util.List;

public interface TrainService {

    static Train save(Train train) {
        return train;
    }

    static Long delete(Long id) {
        return id;
    }

    static Long update(Long id, Train train) {
        return id;
    }


    static Page<Train> getAll(Pageable pageable) {
        return (Page<Train>) pageable;
    }


}