package com.springapp.mvc;

import DataEntities.Membership;
import DataEntities.RegistrationModel;
import DAO.MembershipDAO;
import Factory.HibFactory;
import Utils.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by Sergio on 02.05.14.
 */

@Controller
@RequestMapping(value = "/account")
public class SignupController {
    HibFactory factory = HibFactory.getInstance();

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(HttpSession session, Model model){
        RegistrationModel registrationModel = new RegistrationModel();


        model.addAttribute("registrationModel",registrationModel);

        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String register(@ModelAttribute RegistrationModel user, HttpSession session){
        MembershipDAO dao = factory.getMembershipDao();
        Membership membership = new Membership();
        SecurityUtil util = new SecurityUtil();

        if(util.isValidRegistrationModel(user)){
            membership.setLogin(user.getUserName());
            membership.setPassword(user.getPassword());
            try {
                dao.AddMembership(membership);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else return "register";

        return "redirect:/";
    }


}
