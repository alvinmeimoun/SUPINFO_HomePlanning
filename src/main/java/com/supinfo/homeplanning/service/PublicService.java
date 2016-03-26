package com.supinfo.homeplanning.service;

import com.supinfo.homeplanning.controller.MessageController;
import com.supinfo.homeplanning.entity.CourseEntity;
import com.supinfo.homeplanning.entity.MessageEntity;
import com.supinfo.homeplanning.model.HomeModel;
import com.supinfo.homeplanning.repository.CourseRepository;
import com.supinfo.homeplanning.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    CourseRepository courseRepository;

    public HomeModel generateHomeModel(Date forDate){
        HomeModel model = new HomeModel();

        //Mesages
        model.setMessages(messageRepository.findAll().stream().map(MessageEntity::getMessage)
                .collect(Collectors.toList()));

        //Courses
        List<CourseEntity> todayCoursesEntities = courseRepository.findByDateTimeBetweenOrderByDateTimeAsc(forDate,
                Date.from(forDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atTime(23, 59).atZone(ZoneId.systemDefault()).toInstant()));

        todayCoursesEntities.forEach(c -> {
            Date endDate = new Date(c.getDateTime().getTime() + c.getDuration());
            HomeModel.BookedCourseModel courseModel = new HomeModel.BookedCourseModel()
                .setName(c.getCodeEcts() + " - " + c.getMatiere())
                .setPromotion(Integer.parseInt(c.getPromo()))
                .setSalle(c.getSalle())
                .setTeacher(c.getEnseignant())
                .setStartTime(c.getDateTime())
                .setEndTime(endDate);

            switch (c.getPromo()){
                case "1":
                    model.getAsc1planning().add(courseModel);
                    break;
                case "2":
                    model.getAsc2planning().add(courseModel);
                    break;
                case "3":
                    model.getBscplanning().add(courseModel);
                    break;
                case "4":
                    model.getMsc1planning().add(courseModel);
                    break;
                case "5":
                    model.getMsc2planning().add(courseModel);
                    break;
            }
        });

        return model;
    }

}
