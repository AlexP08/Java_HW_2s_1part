package com.example.Trains.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

/**
 * Сущность рейсы
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "route")
public class Route {

    /**
     * Поле Id сущности
     */
    @Id
    @GeneratedValue(generator = "route_generator")
    @SequenceGenerator(
            name = "route_generator",
            sequenceName = "route_sequence",
            initialValue = 10
    )
    private Long id;



    /**
     * Поле даты отправления поезда в формате LocalDate
     */
    @Column(columnDefinition = "date")
    private LocalDate dateDep;

    /**
     * Поле даты прибытия поезда
     */
    @Column(columnDefinition = "date")
    private LocalDate dateArr;

    /**
     * Поле времени отправления поезда
     */
    @Column(columnDefinition = "time")
    private LocalTime timeDep;

    /**
     * Поле времени прибытия поезда
     */
    @Column(columnDefinition = "time")
    private LocalTime timeArr;

    /**
     * Неопциональное поле внешней связи между маршрутом и станцией отправления
     * представляется в виде сущности {@link City}
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    @JoinColumn(columnDefinition = "depTrain")
    @ToString.Exclude
    private City depCity;

    /**
     * Неопциональное поле внешней связи между маршрутом и станцией прибытия
     * представляется в виде сущности {@link City}
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    @JoinColumn(columnDefinition = "arrTrain")
    @ToString.Exclude
    private City arrCity;

    /**
     * Неопциональное поле внешней связи между маршрутом и поездом
     * представляется в виде cущности {@link Train}
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "train")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @ToString.Exclude
    private Train train;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Route route = (Route) o;
        return Objects.equals(id, route.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}