package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Escola;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-14T21:17:31")
@StaticMetamodel(Distrito.class)
public class Distrito_ { 

    public static volatile SingularAttribute<Distrito, String> nomeDestrito;
    public static volatile ListAttribute<Distrito, Escola> escolaList;
    public static volatile SingularAttribute<Distrito, String> provincia;
    public static volatile SingularAttribute<Distrito, Integer> idDistrito;

}