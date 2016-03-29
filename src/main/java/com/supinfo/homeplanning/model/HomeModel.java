package com.supinfo.homeplanning.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeModel {

    private List<String> messages;
    private List<BookedCourseModel> asc1planning;
    private List<BookedCourseModel> asc2planning;
    private List<BookedCourseModel> bscplanning;
    private List<BookedCourseModel> msc1planning;
    private List<BookedCourseModel> msc2planning;

    public HomeModel() {
        asc1planning = new ArrayList<>();
        bscplanning = new ArrayList<>();
        asc2planning = new ArrayList<>();
        msc1planning = new ArrayList<>();
        msc2planning = new ArrayList<>();
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<BookedCourseModel> getAsc1planning() {
        return asc1planning;
    }

    public void setAsc1planning(List<BookedCourseModel> asc1planning) {
        this.asc1planning = asc1planning;
    }

    public List<BookedCourseModel> getAsc2planning() {
        return asc2planning;
    }

    public void setAsc2planning(List<BookedCourseModel> asc2planning) {
        this.asc2planning = asc2planning;
    }

    public List<BookedCourseModel> getBscplanning() {
        return bscplanning;
    }

    public void setBscplanning(List<BookedCourseModel> bsclpanning) {
        this.bscplanning = bsclpanning;
    }

    public List<BookedCourseModel> getMsc1planning() {
        return msc1planning;
    }

    public void setMsc1planning(List<BookedCourseModel> msc1planning) {
        this.msc1planning = msc1planning;
    }

    public List<BookedCourseModel> getMsc2planning() {
        return msc2planning;
    }

    public void setMsc2planning(List<BookedCourseModel> msc2planning) {
        this.msc2planning = msc2planning;
    }

    public static class BookedCourseModel {
        private int promotion;
        private Date startTime;
        private Date endTime;
        private String name;
        private String teacher;
        private String salle;
        private String code;

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

        public String getCode() {
            return code;
        }

        public BookedCourseModel setCode(String code) {
            this.code = code;
            return this;
        }
    }

}
