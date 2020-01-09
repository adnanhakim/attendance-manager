package com.developer.timetable;

public class CardItem {

    private String subject;
    private String teacher;

    public CardItem(String subject, String teacher) {
        this.subject = subject;
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }
}
