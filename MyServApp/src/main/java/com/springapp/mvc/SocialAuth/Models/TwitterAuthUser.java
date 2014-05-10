package com.springapp.mvc.SocialAuth.Models;

import DataEntities.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "twitter_auth_user")
public class TwitterAuthUser extends User {
    @Column(name = "screen_name", length = 64)
    private String screenName;

    @ Column(name = "oauth_token", length = 80)
    private String oauthToken;

    @ Column(name = "oauth_token_secret", length = 80)
    private String oauthTokenSecret;

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getOauthToken() {
        return oauthToken;
    }

    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }

    public String getOauthTokenSecret() {
        return oauthTokenSecret;
    }

    public void setOauthTokenSecret(String oauthTokenSecret) {
        this.oauthTokenSecret = oauthTokenSecret;
    }

    //any number of available properties
    //getters/setters
}