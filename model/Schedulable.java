package model;

public interface Schedulable {
    void reschedule(String newDate);
    String getScheduleDetails();
}