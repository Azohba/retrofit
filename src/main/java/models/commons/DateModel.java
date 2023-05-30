package models.commons;

import java.util.Calendar;

public class DateModel {

    String date;
    Integer year;
    Integer month;
    Integer day;

    public DateModel(Calendar calendar){
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1; //Months start from index 0, thus the +1
        day = calendar.get(Calendar.DAY_OF_MONTH);

        if (month < 10) this.date = year + "-0" + month + "-" + day;
        else this.date = year + "-" + month + "-" + day;
    }

    public DateModel(String YYYYMMDD){
        year = Integer.parseInt(YYYYMMDD.substring(0,4));
        month = Integer.parseInt(YYYYMMDD.substring(5,7));
        day = Integer.parseInt(YYYYMMDD.substring(8,10));
        this.date = year + "-" + month + "-" + day;
    }

    public DateModel(){}

    public String date() {return date;}

    public void setDate(String date) {this.date = date;}

    public Integer year() {return year;}

    public void setYear(Integer year) {this.year = year;}

    public Integer month() {return month;}

    public void setMonth(Integer month) {this.month = month;}

    public Integer day() {return day;}

    public void setDay(Integer day) {this.day = day;}
}
