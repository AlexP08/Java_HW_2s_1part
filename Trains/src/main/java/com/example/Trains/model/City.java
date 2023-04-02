package com.example.Trains.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Objects;

/**
 * Сущность город
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "city")
public class City  {

    /**
     * Поле Id сущности
     */
    @Id
    @GeneratedValue(generator = "city_generator")
    @SequenceGenerator(
            name = "city_generator",
            sequenceName = "city_sequence",
            initialValue = 10
    )
    private Long id;

    /**
     * Поле имени станции
     */
    @Column(columnDefinition = "text")
    private String name;

    /**
     * Неопциональное поле внешней связи между городом и отправляющимеся поездами, которых она в себе содержит
     * представляется в виде списка Route {@link Route}
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "depStation", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    @ToString.Exclude
    private List<Route> depTrain;

    /**
     * Неопциональное поле внешней связи между станцией и прибывающими поездами, которых она в себе содержит
     * представляется в виде списка Route {@link Route}
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "arrStation", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    @ToString.Exclude
    private List<Route> arrTrain;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        City city = (City) o;
        return Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}