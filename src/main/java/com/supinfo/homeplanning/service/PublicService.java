package com.supinfo.homeplanning.service;

import com.supinfo.homeplanning.model.HomeModel;
import org.springframework.stereotype.Service;

@Service
public class PublicService {

    public HomeModel generateHomeModel(){
        return new HomeModel();
    }

}
