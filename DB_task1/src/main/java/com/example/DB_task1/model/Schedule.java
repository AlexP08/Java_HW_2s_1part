package com.example.DB_task1.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity(name="schedule")
public class Schedule {
    @Id
    @Column(name = "row_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rowID;
    @Column(name = "test_id")
    private Long testID;
    @Column(name = "group_id")
    private Long groupID;
    @Column(name = "duration")
    private Long duration;
    @Column(name = "start_dt")
    private Date startDT;
    @Column(name = "start_time")
    private Time startTime;
    @Column(name = "end_dt")
    private Date endDT;
    @Column(name = "end_time")
    private Time endTime;
    @Column(name = "active")
    private Boolean active;

    public Schedule() {
    }

    public Schedule(Long rowID, Long testID, Long groupID, Long duration, Date startDT, Time startTime, Date endDT, Time endTime, Boolean active) {
        this.rowID = rowID;
        this.testID = testID;
        this.groupID = groupID;
        this.duration = duration;
        this.startDT = startDT;
        this.startTime = startTime;
        this.endDT = endDT;
        this.endTime = endTime;
        this.active = active;
    }
}