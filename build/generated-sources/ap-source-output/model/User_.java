package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.TipoUsuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-14T21:17:31")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, TipoUsuario> idTipo;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, String> email;

}