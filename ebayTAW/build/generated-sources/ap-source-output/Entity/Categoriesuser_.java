package Entity;

import Entity.Categories;
import Entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-04-25T12:21:27")
@StaticMetamodel(Categoriesuser.class)
public class Categoriesuser_ { 

    public static volatile SingularAttribute<Categoriesuser, Integer> categoryUserID;
    public static volatile SingularAttribute<Categoriesuser, Users> userID;
    public static volatile SingularAttribute<Categoriesuser, Categories> categoryID;

}