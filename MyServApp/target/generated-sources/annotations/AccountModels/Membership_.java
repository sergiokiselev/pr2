package AccountModels;

import DataEntities.Membership;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Membership.class)
public abstract class Membership_ {

	public static volatile SingularAttribute<Membership, Integer> userId;
	public static volatile SingularAttribute<Membership, String> login;
	public static volatile SingularAttribute<Membership, String> password;

}

