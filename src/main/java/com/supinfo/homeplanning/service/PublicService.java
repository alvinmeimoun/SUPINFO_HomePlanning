package com.supinfo.homeplanning.service;

import com.supinfo.homeplanning.controller.MessageController;
import com.supinfo.homeplanning.entity.CourseEntity;
import com.supinfo.homeplanning.entity.MessageEntity;
import com.supinfo.homeplanning.model.HomeModel;
import com.supinfo.homeplanning.repository.CourseRepository;
import com.supinfo.homeplanning.repository.MessageRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
            DateFormat hourDf = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault());

            HomeModel.BookedCourseModel courseModel = new HomeModel.BookedCourseModel()
                .setName(c.getCodeEcts() + " - " + c.getMatiere())
                .setPromotion(Integer.parseInt(c.getPromo()))
                .setTeacher(c.getEnseignant())
                .setCode(c.getCodeEcts())
                .setStartHour(hourDf.format(c.getDateTime()))
                .setEndHour(hourDf.format(endDate));

            if(c.getSalle() == null || c.getSalle().length() == 0) courseModel.setSalle("");
            else if (StringUtils.isNumeric(c.getSalle())) courseModel.setSalle("Salle "+c.getSalle());
            else courseModel.setSalle(c.getSalle());

            switch (c.getPromo()){
                case "1":
                    if(model.getAsc1planning().size() != 0){
                        HomeModel.BookedCourseModel lastModel = model.getAsc1planning().get(model.getAsc1planning().size()-1);
                        if(lastModel.getSalle().equals(courseModel.getSalle()) && lastModel.getCode().equals(courseModel.getCode())
                                && lastModel.getTeacher().equals(courseModel.getTeacher())
                                && lastModel.getName().equals(courseModel.getName())
                                && lastModel.getEndHour().equals(courseModel.getStartHour())){
                            //C'est le même cour mais splitté, on l'unifie au cours précédent
                            lastModel.setEndHour(courseModel.getEndHour());
                            break;
                        }
                    }
                    //Ce n'est pas le même cours, on ajoute une nouvelle entrée
                    model.getAsc1planning().add(courseModel);
                    break;
                case "2":
                    if(model.getAsc2planning().size() != 0){
                        HomeModel.BookedCourseModel lastModel = model.getAsc2planning().get(model.getAsc2planning().size()-1);
                        if(lastModel.getSalle().equals(courseModel.getSalle()) && lastModel.getCode().equals(courseModel.getCode())
                                && lastModel.getTeacher().equals(courseModel.getTeacher())
                                && lastModel.getName().equals(courseModel.getName())
                        && lastModel.getEndHour().equals(courseModel.getStartHour())){
                            //C'est le même cour mais splitté, on l'unifie au cours précédent
                            lastModel.setEndHour(courseModel.getEndHour());
                            break;
                        }
                    }
                    //Ce n'est pas le même cours, on ajoute une nouvelle entrée
                    model.getAsc2planning().add(courseModel);
                    break;
                case "3":
                    if(model.getBscplanning().size() != 0){
                        HomeModel.BookedCourseModel lastModel = model.getBscplanning().get(model.getBscplanning().size()-1);
                        if(lastModel.getSalle().equals(courseModel.getSalle()) && lastModel.getCode().equals(courseModel.getCode())
                                && lastModel.getTeacher().equals(courseModel.getTeacher())
                                && lastModel.getName().equals(courseModel.getName())
                        && lastModel.getEndHour().equals(courseModel.getStartHour())){
                            //C'est le même cour mais splitté, on l'unifie au cours précédent
                            lastModel.setEndHour(courseModel.getEndHour());
                            break;
                        }
                    }
                    //Ce n'est pas le même cours, on ajoute une nouvelle entrée
                    model.getBscplanning().add(courseModel);
                    break;
                case "4":
                    if(model.getMsc1planning().size() != 0){
                        HomeModel.BookedCourseModel lastModel = model.getMsc1planning().get(model.getMsc1planning().size()-1);
                        if(lastModel.getSalle().equals(courseModel.getSalle()) && lastModel.getCode().equals(courseModel.getCode())
                                && lastModel.getTeacher().equals(courseModel.getTeacher())
                                && lastModel.getName().equals(courseModel.getName())
                        && lastModel.getEndHour().equals(courseModel.getStartHour())){
                            //C'est le même cour mais splitté, on l'unifie au cours précédent
                            lastModel.setEndHour(courseModel.getEndHour());
                            break;
                        }
                    }
                    //Ce n'est pas le même cours, on ajoute une nouvelle entrée
                    model.getMsc1planning().add(courseModel);
                    break;
                case "5":
                    if(model.getMsc2planning().size() != 0){
                        HomeModel.BookedCourseModel lastModel = model.getMsc2planning().get(model.getMsc2planning().size()-1);
                        if(lastModel.getSalle().equals(courseModel.getSalle()) && lastModel.getCode().equals(courseModel.getCode())
                                && lastModel.getTeacher().equals(courseModel.getTeacher())
                                && lastModel.getName().equals(courseModel.getName())
                        && lastModel.getEndHour().equals(courseModel.getStartHour())){
                            //C'est le même cour mais splitté, on l'unifie au cours précédent
                            lastModel.setEndHour(courseModel.getEndHour());
                            break;
                        }
                    }
                    //Ce n'est pas le même cours, on ajoute une nouvelle entrée
                    model.getMsc2planning().add(courseModel);
                    break;
            }
        });

        return model;
    }

}
