package com.example.Trains.controller;

import com.example.Trains.service.TrainService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.example.Trains.model.Train;

/**
 * Контроллер поездов
 */
@RestController
public class TrainController {



    /**
     * Контроллер GET запроса по ссылке "/trains"
     */
    @GetMapping("/trains")
    public Page<Train> getAllCars(Pageable pageable) {
        return TrainService.getAll(pageable);
    }



    /**
     * Контроллер POST запроса по ссылке "/trains"
     */
    @PostMapping("/trains")
    public TrainService addTrain( @RequestBody Train train) {
        return (TrainService) TrainService.save(train);
    }

    /**
     * Контроллер PUT запроса по ссылке "/trains/{trainId}"
     */
    @PutMapping("/trains/{trainId}")
    public Long updateTrain(@PathVariable Long trainId,
                            @RequestBody Train train) {
        return TrainService.update(trainId, train);
    }

    /**
     * Контроллер DELETE запроса по ссылке "/trains/{trainId}"
     */
    @DeleteMapping("/trains/{trainId}")
    public Long deleteTrain(@PathVariable Long trainId) {
        return TrainService.delete(trainId);
    }
}
