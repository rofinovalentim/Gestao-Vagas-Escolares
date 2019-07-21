package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Genero;
import model.Vagas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-14T21:17:32")
@StaticMetamodel(Estudante.class)
public class Estudante_ { 

    public static volatile SingularAttribute<Estudante, Integer> telefone;
    public static volatile SingularAttribute<Estudante, Vagas> vagas;
    public static volatile SingularAttribute<Estudante, String> nomeEstudante;
    public static volatile SingularAttribute<Estudante, Integer> idEstudante;
    public static volatile SingularAttribute<Estudante, String> nrBI;
    public static volatile SingularAttribute<Estudante, Genero> idGenero;
    public static volatile SingularAttribute<Estudante, Date> dataNascimento;
    public static volatile SingularAttribute<Estudante, String> email;

}