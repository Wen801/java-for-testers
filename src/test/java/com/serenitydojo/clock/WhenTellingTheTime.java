package com.serenitydojo.clock;

import org.junit.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;


public class WhenTellingTheTime {

    @Test
    public void weShouldUseTheRealLocalTimeByDefault(){
       // LocalTime now = LocalTime.now();
        TalkingClock talkingClock = new TalkingClock();
        System.out.println(talkingClock.currentTimeInWords());

    }

    @Test
    public void midnight(){
        //Given It Is Now 00:00


        TalkingClock talkingClock = clockAt(0,0);
       // System.out.println("current time is "+currentTime);
        String timeNowIs = talkingClock.currentTimeInWords();
        assertThat(timeNowIs).isEqualTo("midnight");
    }

    @Test
    public void midday(){
        TalkingClock clock = clockAt(12,0);
        assertThat(clock.currentTimeInWords()).isEqualTo("midday");
    }

    TalkingClock clockAt(int hours, int minutes){

       // CurrentTime currentTime = DummyClock.showing(hours,minutes);
       // TalkingClock talkingClock = new TalkingClock(currentTime);

        //below code is the same as previous 2 lines
        return new TalkingClock(DummyClock.showing(hours,minutes));
    }
}
