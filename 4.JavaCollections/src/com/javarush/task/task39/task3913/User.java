package com.javarush.task.task39.task3913;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class User{
    public String ip;
    public String name;
    public Date date;
    public Event event;
    public int addEvent;
    public Status status;

    public Calendar month;
    public Calendar day;
    public String strDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return addEvent == user.addEvent &&
                Objects.equals(ip, user.ip) &&
                Objects.equals(name, user.name) &&
                Objects.equals(date, user.date) &&
                event == user.event &&
                status == user.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return
                " " + ip +
                " " + name +
                " " + date +
                " " + event +
                " " + addEvent +
                " " + status +
                " " + month +
                " " + day +
                " " + strDate
                ;
    }
}
