package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Escola;
import model.Estudante;
import model.VagasPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-14T21:17:31")
@StaticMetamodel(Vagas.class)
public class Vagas_ { 

    public static volatile ListAttribute<Vagas, Estudante> estudanteList;
    public static volatile SingularAttribute<Vagas, Escola> escola;
    public static volatile SingularAttribute<Vagas, Integer> nrVagas;
    public static volatile SingularAttribute<Vagas, VagasPK> vagasPK;

}