package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Distrito;
import model.Vagas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-14T21:17:31")
@StaticMetamodel(Escola.class)
public class Escola_ { 

    public static volatile SingularAttribute<Escola, Distrito> iddistrito;
    public static volatile ListAttribute<Escola, Vagas> vagasList;
    public static volatile SingularAttribute<Escola, Integer> telefone;
    public static volatile SingularAttribute<Escola, String> endereco;
    public static volatile SingularAttribute<Escola, Integer> idEscola;
    public static volatile SingularAttribute<Escola, String> nomeEscola;
    public static volatile SingularAttribute<Escola, String> email;

}