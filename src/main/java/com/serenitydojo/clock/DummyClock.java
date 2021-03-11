package com.serenitydojo.clock;

import java.time.LocalTime;

public class DummyClock implements CurrentTime {

    private final int hour;
    private final int minutes;

    public static DummyClock showing (int hour, int minute){
        return new DummyClock(hour, minute);
    }

    public DummyClock(int hour, int minute) {
        this.hour = hour;
        this.minutes = minute;
    }

    @Override
    public int getHour() {
        return hour;
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public LocalTime asLocalTime() {
        return LocalTime.of(hour, minutes);
    }
}
