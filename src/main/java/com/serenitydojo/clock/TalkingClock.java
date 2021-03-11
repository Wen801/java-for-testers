package com.serenitydojo.clock;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

//TalkingClock's job is taking current time and convert to text;
public class TalkingClock {

    private final CurrentTime currentTime;

    //this constructor invoke the next constructor
    public TalkingClock(){
        this(new CurrentLocalTime());
    }

    public TalkingClock(CurrentTime currentTime) {
        this.currentTime = currentTime;
    }


    public String currentTimeInWords() {
        Map<Integer, String> minutes = new HashMap<Integer, String>() {
            {
                put(0, "o'clock");
                put(1, "o one");
                put(2, "o two");
                put(3, "o three");
                put(4, "o four");
                put(5, "o five");
                put(6, "o six");
                put(7, "o seven");
                put(8, "o eight");
                put(9, "o nine");
                put(10, "ten");
                put(11, "eleven");
                put(12, "twelve");
                put(13, "thirteen");
                put(14, "fourteen");
                put(15, "fifteen");
                put(16, "sixteen");
                put(17, "seventeen");
                put(18, "eighteen");
                put(19, "eighteen");
                put(20, "twenty");
                put(21, "twenty-one");
                put(22, "twenty-two");
                put(23, "twenty-three");
                put(24, "twenty-four");
                put(25, "twenty-five");
                put(26, "twenty-six");
                put(27, "twenty-seven");
                put(28, "twenty-eight");
                put(29, "twenty-nine");
                put(30, "thirty");
                put(41, "forty-one");
                put(42, "forty-two");
                put(43, "forty-three");
                put(44, "forty-four");
                put(45, "forty-five");
                put(46, "forty-six");
                put(47, "forty-seven");
                put(48, "forty-eight");
                put(49, "forty-nine");
                put(50, "fifty");
                put(51, "fifty-one");
                put(52, "fifty-two");
                put(53, "fifty-three");
                put(54, "fifty-four");
                put(55, "fifty-five");
                put(56, "fifty-six");
                put(57, "fifty-seven");
                put(58, "fifty-eight");
                put(59, "fifty-nine");
            }
        };
        Map<Integer, String> hours = new HashMap<Integer, String>() {
            {
                put(1, "one");
                put(2, "two");
                put(3, "three");
                put(4, "four");
                put(5, "five");
                put(6, "six");
                put(7, "seven");
                put(8, "eight");
                put(9, "nine");
                put(10, "ten");
                put(11, "eleven");
                put(12, "twelve");
                put(13, "one");
                put(14, "two");
                put(15, "three");
                put(16, "four");
                put(17, "five");
                put(18, "six");
                put(19, "seven");
                put(20, "eight");
                put(21, "nine");
                put(22, "ten");
                put(23, "eleven");
                put(0, "twelve");
            }
        };
        Integer hour=currentTime.getHour();
        Integer minute=currentTime.getMinutes();

        if((currentTime.getHour()==0) &&(currentTime.getMinutes()==0 ))
        {
            return "midnight";
        }
        if((currentTime.getHour()==12) &&(currentTime.getMinutes()==0 ))
        {
            return "midday";
        }
        if(currentTime.getHour()<12)
            return "current time is "+hours.get(hour) + " " +minutes.get(minute) + " am";
            else
                return "current time is "+hours.get(hour) + " " +minutes.get(minute) + " pm";
    }
}
