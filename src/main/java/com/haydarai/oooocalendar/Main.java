package com.haydarai.oooocalendar;

public class Main {

    public static void main(String[] args) {
        OoooSmartClock clock = new OoooSmartClock();
        try {
            clock.setTimeZone();
        } catch (NoDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(clock.getLocalCurrentTimeStamp());
    }
}
