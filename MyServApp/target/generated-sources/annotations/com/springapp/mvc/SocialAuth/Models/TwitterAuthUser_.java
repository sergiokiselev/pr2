package com.springapp.mvc.SocialAuth.Models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TwitterAuthUser.class)
public abstract class TwitterAuthUser_ extends DataEntities.User_ {

	public static volatile SingularAttribute<TwitterAuthUser, String> oauthToken;
	public static volatile SingularAttribute<TwitterAuthUser, String> oauthTokenSecret;
	public static volatile SingularAttribute<TwitterAuthUser, String> screenName;

}

