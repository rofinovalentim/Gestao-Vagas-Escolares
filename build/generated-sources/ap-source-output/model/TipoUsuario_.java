package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Role;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-14T21:17:31")
@StaticMetamodel(TipoUsuario.class)
public class TipoUsuario_ { 

    public static volatile ListAttribute<TipoUsuario, User> userList;
    public static volatile SingularAttribute<TipoUsuario, Integer> idTipo;
    public static volatile ListAttribute<TipoUsuario, Role> roleList;
    public static volatile SingularAttribute<TipoUsuario, String> descricao;

}