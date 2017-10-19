package com.haydar.oooocalendar;

import com.haydarai.oooocalendar.NoDataException;
import com.haydarai.oooocalendar.OoooSmartClock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClock {

    private OoooSmartClock clock;

    @Before
    public void setUp() {
        clock = new OoooSmartClock();
    }

    /**
     * Check whether the timezone setter works fine by using timezone getter
     */
    @Test
    public void testSetTimeZone() {
        try {
            clock.setTimeZone(21);
            Assert.assertEquals(21, clock.getTimeZone());
        } catch (NoDataException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check whether both of these return the same kind of string
     * Will fail on special occasions ("NOON", "MIDNIGHT", "FATHER'S DAY", etc)
     */
    @Test
    public void testCurrentTimeStamp() {
        try {
            clock.setTimeZone(20); // Set it to your actual timezone
            Assert.assertEquals(clock.getCurrentTimeStamp(), clock.getLocalCurrentTimeStamp());
        } catch (NoDataException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check whether it shows the right response on double tenth day
     * Only succeed if your date is currently on double tenth day
     */
    @Test
    public void testDoubleTenthDay() {
        try {
            clock.setTimeZone(20); // Set it to your actual timezone
            Assert.assertTrue(clock.getLocalCurrentTimeStamp().contains("-10-10")
                    && clock.getLocalCurrentTimeStamp().contains("DOUBLE-TENTH DAY"));
        } catch (NoDataException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check whether it shows the right response on father's day
     * Only succeed if your date is currently on father's day
     */
    @Test
    public void testFathersDay() {
        try {
            clock.setTimeZone(20); // Set it to your actual timezone
            Assert.assertTrue(clock.getLocalCurrentTimeStamp().contains("-08-08")
                    && clock.getLocalCurrentTimeStamp().contains("FATHER'S DAY"));
        } catch (NoDataException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check whether it shows the right response on father's day
     * Only succeed if your date is currently on x'mas day
     */
    @Test
    public void testXmasDay() {
        try {
            clock.setTimeZone(20); // Set it to your actual timezone
            Assert.assertTrue(clock.getLocalCurrentTimeStamp().contains("-12-25")
                    && clock.getLocalCurrentTimeStamp().contains("X'MAS DAY"));
        } catch (NoDataException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check whether it shows the right response on noon
     * Only succeed if your time is currently at noon
     */
    @Test
    public void testNoon() {
        try {
            clock.setTimeZone(20); // Set it to your actual timezone
            Assert.assertTrue((clock.getLocalCurrentTimeStamp().contains("12:00:") ||
                    clock.getLocalCurrentTimeStamp().contains("12:01:"))
                    && clock.getLocalCurrentTimeStamp().contains("NOON"));
        } catch (NoDataException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check whether it shows the right response on midnight
     * Only succeed if your time is currently at midnight
     */
    @Test
    public void testMidnight() {
        try {
            clock.setTimeZone(20); // Set it to your actual timezone
            Assert.assertTrue((clock.getLocalCurrentTimeStamp().contains("00:00:") ||
                    clock.getLocalCurrentTimeStamp().contains("00:01:"))
                    && clock.getLocalCurrentTimeStamp().contains("MIDNIGHT"));
        } catch (NoDataException e) {
            e.printStackTrace();
        }
    }
}