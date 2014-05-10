package com.springapp.mvc.SocialAuth.Models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacebookAuthUser.class)
public abstract class FacebookAuthUser_ extends DataEntities.User_ {

	public static volatile SingularAttribute<FacebookAuthUser, String> lastName;
	public static volatile SingularAttribute<FacebookAuthUser, String> token;
	public static volatile SingularAttribute<FacebookAuthUser, String> email;
	public static volatile SingularAttribute<FacebookAuthUser, String> firstName;

}

