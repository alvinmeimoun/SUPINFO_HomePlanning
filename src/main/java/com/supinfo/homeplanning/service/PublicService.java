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

        List<HomeModel.BookedCourseModel> coursesModels = new ArrayList<>();

        todayCoursesEntities.forEach(c -> {
            Date endDate = new Date(c.getDateTime().getTime() + c.getDuration());
            coursesModels.add(new HomeModel.BookedCourseModel()
                .setName(c.getCodeEcts() + " - " + c.getMatiere())
                .setPromotion(Integer.parseInt(c.getPromo()))
                .setSalle(c.getSalle())
                .setTeacher(c.getEnseignant())
                .setStartTime(c.getDateTime())
                .setEndTime(endDate));
        });
        model.setTodayPlanning(coursesModels);

        return model;
    }

}
