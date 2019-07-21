package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.TipoUsuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-14T21:17:31")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, String> recurso;
    public static volatile SingularAttribute<Role, String> role;
    public static volatile ListAttribute<Role, TipoUsuario> tipoUsuarioList;

}