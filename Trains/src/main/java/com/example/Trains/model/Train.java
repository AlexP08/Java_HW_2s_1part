package com.example.Trains.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Objects;

/**
 * Сущность поездов
 */
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "train")
@NoArgsConstructor
public class Train {

    /**
     * Поле id сущности
     */
    @Id
    @GeneratedValue(generator = "train_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "train_generator",
            sequenceName = "train_sequence",
            initialValue = 10
    )
    private Long id;

    /**
     * Поле имени
     */
    @Column(columnDefinition = "name")
    private String name;

    /**
     * Неопциональное поле внешней связи между поездом и типом поезда
     * представляется в виде класса TrainType {@link TrainType}
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "train_type")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    @ToString.Exclude
    private TrainType trainType;

    /**
     * Неопциональное поле внешней связи между поездом маршрутом
     * представляется в виде сущности Route {@link Route}
     */
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "train_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    @ToString.Exclude
    private Route route;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Train train = (Train) o;
        return Objects.equals(id, train.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
