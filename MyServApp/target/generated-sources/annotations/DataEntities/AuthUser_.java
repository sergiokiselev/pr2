package DataEntities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.xml.registry.infomodel.User;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AuthUser.class)
public abstract class AuthUser_ {

	public static volatile SingularAttribute<AuthUser, Long> id;
	public static volatile SingularAttribute<AuthUser, Boolean> enabled;
	public static volatile SingularAttribute<AuthUser, Long> binaryAuthorities;
	public static volatile SingularAttribute<AuthUser, AuthorityType> type;
	public static volatile SingularAttribute<AuthUser, User> user;
	public static volatile SingularAttribute<AuthUser, String> identificationName;

}

