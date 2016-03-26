package com.supinfo.homeplanning.repository;

import com.supinfo.homeplanning.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    public List<CourseEntity> findByDateTimeBetweenOrderByDateTimeAsc(Date dayBegin, Date dayEnd);

}