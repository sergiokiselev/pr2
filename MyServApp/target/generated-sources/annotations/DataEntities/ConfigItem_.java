package DataEntities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ConfigItem.class)
public abstract class ConfigItem_ {

	public static volatile SingularAttribute<ConfigItem, Integer> id;
	public static volatile SingularAttribute<ConfigItem, String> configName;
	public static volatile SingularAttribute<ConfigItem, String> tag;
	public static volatile SingularAttribute<ConfigItem, String> description;
	public static volatile SingularAttribute<ConfigItem, Integer> authorId;

}

