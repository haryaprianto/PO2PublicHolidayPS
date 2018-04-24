package com.example.a16022596.po2publicholidayps;

public class HolidayDetail {
    private String holidayTitle;
    private String holidayDate;

    public HolidayDetail(String holidayTitle, String holidayDate) {
        this.holidayTitle = holidayTitle;
        this.holidayDate = holidayDate;
    }

    public String getHolidayTitle() {
        return holidayTitle;
    }

    public String getHolidayDate() {
        return holidayDate;
    }
}
