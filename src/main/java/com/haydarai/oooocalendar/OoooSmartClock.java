package com.haydarai.oooocalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class OoooSmartClock {

    private int timeZone;

    public OoooSmartClock() {
        this.timeZone = 20;
    }

    OoooSmartClock(int timeZone) {
        this.timeZone = timeZone;
    }

    public void setTimeZone() throws NoDataException {
        int selectedTimeZone = new StubOoooSetTimeZoneDialog().chooseTimeZone();
        if (selectedTimeZone < 0 || selectedTimeZone > 23) {
            throw new NoDataException("No proper time zone selected");
        }
    }

    public void setTimeZone(int index) throws NoDataException {
        if (index < 0 || index > 23) {
            throw new NoDataException("No proper time zone selected");
        }
        timeZone = index;
    }

    public int getTimeZone() throws NoDataException {
        return timeZone;
    }

    public String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public String getLocalCurrentTimeStamp() {
        /**
         *  GMT timezones in Unicode is a bit weird...
         *  If you use Etc/GMT-8, it means that it's actually GMT+8.
         *  If you use Etc/GMT+5, it means that it's actually GMT-5
         *  To see the detailed list it's in here:
         *  http://unicode.org/repos/cldr/trunk/common/supplemental/windowsZones.xml
         */

        String timeZoneString;

        switch (timeZone) {
            default: timeZoneString = "Asia/Taipei"; break;
            case 0: timeZoneString = "Etc/GMT+12"; break;
            case 1: timeZoneString = "Etc/GMT+11"; break;
            case 2: timeZoneString = "Etc/GMT+10"; break;
            case 3: timeZoneString = "Etc/GMT+9"; break;
            case 4: timeZoneString = "Etc/GMT+8"; break;
            case 5: timeZoneString = "Etc/GMT+7"; break;
            case 6: timeZoneString = "Etc/GMT+6"; break;
            case 7: timeZoneString = "Etc/GMT+5"; break;
            case 8: timeZoneString = "Etc/GMT+4"; break;
            case 9: timeZoneString = "Etc/GMT+3"; break;
            case 10: timeZoneString = "Etc/GMT+2"; break;
            case 11: timeZoneString = "Etc/GMT+1"; break;
            case 12: timeZoneString = "Etc/GMT"; break;
            case 13: timeZoneString = "Etc/GMT-1"; break;
            case 14: timeZoneString = "Etc/GMT-2"; break;
            case 15: timeZoneString = "Etc/GMT-3"; break;
            case 16: timeZoneString = "Etc/GMT-4"; break;
            case 17: timeZoneString = "Etc/GMT-5"; break;
            case 18: timeZoneString = "Etc/GMT-6"; break;
            case 19: timeZoneString = "Etc/GMT-7"; break;
            case 20: timeZoneString = "Etc/GMT-8"; break;
            case 21: timeZoneString = "Etc/GMT-9"; break;
            case 22: timeZoneString = "Etc/GMT-10"; break;
            case 23: timeZoneString = "Etc/GMT-11"; break;
        }

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneString));

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH start from 0
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        String fullDate = year + "-" + String.format ("%02d", month) + "-" + String.format ("%02d", day);
        String nameOfDay = "";
        String time = " " + hour + ":" + String.format ("%02d", minute) + ":" + String.format ("%02d", second);

        if (month == 10 && day == 10) {
            nameOfDay = " DOUBLE-TENTH DAY";
        } else if (month == 8 && day == 8) {
            nameOfDay = " FATHER'S DAY";
        } else if (month == 12 && day == 25) {
            nameOfDay = " X'MAS DAY";
        }

        if (hour == 12 && (minute == 0 || minute == 1)) {
            time = " NOON";
        } else if (hour == 18 && (minute == 0 || minute == 1)) {
            time = " MIDNIGHT";
        }

        return fullDate + nameOfDay + time;
    }
}