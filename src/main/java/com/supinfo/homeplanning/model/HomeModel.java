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

    public class BookedCourseModel {
        private int promotion;
        private Date startTime;
        private Date endTime;
        private String name;
        private String teacher;
        private String salle;

        public int getPromotion() {
            return promotion;
        }

        public void setPromotion(int promotion) {
            this.promotion = promotion;
        }

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }

        public String getSalle() {
            return salle;
        }

        public void setSalle(String salle) {
            this.salle = salle;
        }
    }

}
