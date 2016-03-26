package com.supinfo.homeplanning.model;

import java.util.Date;
import java.util.List;

public class HomeModel {

    private List<String> messages;
    private List<BookedCourseModel> todayPlanning;

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<BookedCourseModel> getTodayPlanning() {
        return todayPlanning;
    }

    public void setTodayPlanning(List<BookedCourseModel> todayPlanning) {
        this.todayPlanning = todayPlanning;
    }

    public static class BookedCourseModel {
        private int promotion;
        private Date startTime;
        private Date endTime;
        private String name;
        private String teacher;
        private String salle;

        public int getPromotion() {
            return promotion;
        }

        public BookedCourseModel setPromotion(int promotion) {
            this.promotion = promotion;
            return this;
        }

        public Date getStartTime() {
            return startTime;
        }

        public BookedCourseModel setStartTime(Date startTime) {
            this.startTime = startTime;
            return this;
        }

        public Date getEndTime() {
            return endTime;
        }

        public BookedCourseModel setEndTime(Date endTime) {
            this.endTime = endTime;
            return this;
        }

        public String getName() {
            return name;
        }

        public BookedCourseModel setName(String name) {
            this.name = name;
            return this;
        }

        public String getTeacher() {
            return teacher;
        }

        public BookedCourseModel setTeacher(String teacher) {
            this.teacher = teacher;
            return this;
        }

        public String getSalle() {
            return salle;
        }

        public BookedCourseModel setSalle(String salle) {
            this.salle = salle;
            return this;
        }
    }

}
