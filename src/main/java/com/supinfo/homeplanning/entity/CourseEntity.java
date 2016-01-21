package com.supinfo.homeplanning.entity;

import java.util.Date;

public class CourseEntity {

    private String codeEcts;
    private Date dateTime;
    private String promo;
    private String matiere;
    private String enseignant;
    private Long duration;
    private String salle;

    public String getCodeEcts() {
        return codeEcts;
    }

    public CourseEntity setCodeEcts(String codeEcts) {
        this.codeEcts = codeEcts;
        return this;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public CourseEntity setDateTime(Date dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getPromo() {
        return promo;
    }

    public CourseEntity setPromo(String promo) {
        this.promo = promo;
        return this;
    }

    public String getMatiere() {
        return matiere;
    }

    public CourseEntity setMatiere(String matiere) {
        this.matiere = matiere;
        return this;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public CourseEntity setEnseignant(String enseignant) {
        this.enseignant = enseignant;
        return this;
    }

    public Long getDuration() {
        return duration;
    }

    public CourseEntity setDuration(Long duration) {
        this.duration = duration;
        return this;
    }

    public String getSalle() {
        return salle;
    }

    public CourseEntity setSalle(String salle) {
        this.salle = salle;
        return this;
    }
}
