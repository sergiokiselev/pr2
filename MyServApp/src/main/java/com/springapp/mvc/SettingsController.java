package com.springapp.mvc;

import DAO.ConfigItemDao;
import DataEntities.ConfigItem;
import Factory.HibFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by Sergio on 10.05.14.
 */
@Controller
@RequestMapping(value = "/settings")
public class SettingsController {
    HibFactory factory = HibFactory.getInstance();

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public void save(@RequestBody ConfigItem configItem){
        ConfigItemDao dao = factory.getConfigItemDao();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveSetting(@ModelAttribute ConfigItem configItem, HttpSession session){
        ConfigItemDao configItemDao = factory.getConfigItemDao();

    }
}


//            consumes = MediaType.APPLICATION_JSON_VALUE