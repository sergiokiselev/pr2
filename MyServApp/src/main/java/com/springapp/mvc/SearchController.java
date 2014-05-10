package com.springapp.mvc;

import DAO.UserDAO;
import DataEntities.ConfigItem;
import DataEntities.User;
import Factory.HibFactory;
import Utils.LuceneService;
import java.io.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sergio on 28.04.14.
 */



public class SearchController {
    HibFactory factory = HibFactory.getInstance();
    UserDAO userDAO = factory.getUserDAO();

    @RequestMapping("/index")
    public String Index(){
        return "/Search/index";
    }


    @RequestMapping(method = RequestMethod.GET)
    public String Index(Model model, String searchTerm, String searchField, Boolean searchDefault, int limit, int page ) {
        // create default Lucene search index directory
        //if (!Directory.Exists(LuceneService._luceneDir))
        //  Directory.CreateDirectory(LuceneService._luceneDir);
        File dir = new File(LuceneService._luceneDir);
        dir.mkdir();

        // perform Lucene search
        ArrayList<ConfigItem> _searchResults;
        _searchResults =  LuceneService.SearchDefault(searchTerm, searchField);
        //  if (searchTerm == null || searchTerm.isEmpty())
        //    _searchResults = LuceneService.GetAllIndexRecords();

        model.addAttribute("searchResult",_searchResults);

        ArrayList<User> allSampleData;

        try {
            allSampleData = (ArrayList<User>) userDAO.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "/Search/search";
    }
    @RequestMapping(method = RequestMethod.GET)
    public String Search(String searchTerm, String searchField, String searchDefault)
    {
        return "Search/search";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String CreateIndex()
    {
        //try {
        //  LuceneService.AddUpdateLuceneIndex(userDAO.getAllUsers());
        //} catch (SQLException e) {
        //  e.printStackTrace();
        //}
        //TempData["Result"] = "Search index was created successfully!";
        return "Search/search";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String AddToIndex(ConfigItem sampleData)
    {
        try {
            LuceneService.addConfigToIndex(sampleData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //TempData["Result"] = "Record was added to search index successfully!";
        return "Search/search";
    }

    public void ClearIndex()
    {
        LuceneService.clearLuceneIndex();
    }

    public void ClearIndexRecord(int id)
    {
        LuceneService.clearLuceneIndexRecord(id);

    }
}
