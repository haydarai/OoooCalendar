package com.haydar.oooocalendar;

import com.haydarai.oooocalendar.NoDataException;
import com.haydarai.oooocalendar.OoooSmartClock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRocket {

    private OoooSmartClock clock;

    @Before
    public void setUp() {
        clock = new OoooSmartClock();
    }

    @Test
    public void testSetTimeZone() {
        try {
            clock.setTimeZone(21);
            Assert.assertEquals(21, clock.getTimeZone());
        } catch (NoDataException e) {
            e.printStackTrace();
        }
    }
}
