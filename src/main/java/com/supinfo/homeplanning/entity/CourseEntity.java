package com.supinfo.homeplanning.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "COURSE")
public class CourseEntity {

    private Long id;
    private String codeEcts;
    private Date dateTime;
    private String promo;
    private String matiere;
    private String enseignant;
    private Long duration;
    private String salle;

    @Id
    @NotNull
    public Long getId() {
        return id;
    }

    public CourseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    @Column(name = "CODE_ECTS")
    public String getCodeEcts() {
        return codeEcts;
    }

    public CourseEntity setCodeEcts(String codeEcts) {
        this.codeEcts = codeEcts;
        return this;
    }

    @Column(name = "DATETIME")
    public Date getDateTime() {
        return dateTime;
    }

    public CourseEntity setDateTime(Date dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    @Column(name = "PROMO")
    public String getPromo() {
        return promo;
    }

    public CourseEntity setPromo(String promo) {
        this.promo = promo;
        return this;
    }

    @Column(name = "MATIERE")
    public String getMatiere() {
        return matiere;
    }

    public CourseEntity setMatiere(String matiere) {
        this.matiere = matiere;
        return this;
    }

    @Column(name = "ENSEIGNANT")
    public String getEnseignant() {
        return enseignant;
    }

    public CourseEntity setEnseignant(String enseignant) {
        this.enseignant = enseignant;
        return this;
    }

    @Column(name = "DURATION")
    public Long getDuration() {
        return duration;
    }

    public CourseEntity setDuration(Long duration) {
        this.duration = duration;
        return this;
    }

    @Column(name = "SALLE")
    public String getSalle() {
        return salle;
    }

    public CourseEntity setSalle(String salle) {
        this.salle = salle;
        return this;
    }
}
