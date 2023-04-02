package com.example.Trains.model;

import lombok.*;
import org.hibernate.Hibernate;
import jakarta.persistence.*;
import java.util.Objects;

/**
 * Сущность типа поезда {@link Train}.
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "train_type")
public class TrainType {

    /**
     * Поле Id сущности
     */
    @Id
    private Long id;

    /**
     * Поле названия типа поезда
     */
    @Column(columnDefinition = "text")
    private String name;

    public TrainType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TrainType trainType = (TrainType) o;
        return Objects.equals(id, trainType.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}