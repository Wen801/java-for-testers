package com.serenitydojo.clock;

//The job for this interface is to return the hour and minutes.

import java.time.LocalTime;

public interface CurrentTime {

    int getHour();
    int getMinutes();

    LocalTime asLocalTime();
}
