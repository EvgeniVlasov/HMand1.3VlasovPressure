package com.example.hmand13vlasovpressure;


import java.sql.Time;
import java.util.Date;

public class UserPressure {
    int pressureUp;
    int pressureDown;
    int pulse;
    boolean tahird;
    String date;
    String time;

    UserPressure(int pressureUp, int pressureDown, int pulse, boolean tahird, String date, String time) {
        this.pressureUp = pressureUp;
        this.pressureDown = pressureDown;
        this.pulse = pulse;
        this.tahird = tahird;
        this.date = date;
        this.time = time;
    }
}
