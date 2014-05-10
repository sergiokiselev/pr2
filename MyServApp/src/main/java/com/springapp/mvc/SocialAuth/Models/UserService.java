package com.springapp.mvc.SocialAuth.Models;

import DataEntities.RegistrationForm;
import DataEntities.User;

public interface UserService {

    public User registerNewUserAccount(RegistrationForm userAccountData);
}