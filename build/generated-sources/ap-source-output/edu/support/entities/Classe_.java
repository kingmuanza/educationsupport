package edu.support.entities;

import edu.support.entities.Eleve;
import edu.support.entities.Evaluation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Classe.class)
public class Classe_ { 

    public static volatile SingularAttribute<Classe, Integer> idclasse;
    public static volatile SingularAttribute<Classe, String> code;
    public static volatile SingularAttribute<Classe, Boolean> deleted;
    public static volatile SingularAttribute<Classe, Date> created;
    public static volatile ListAttribute<Classe, Eleve> eleveList;
    public static volatile ListAttribute<Classe, Evaluation> evaluationList;
    public static volatile SingularAttribute<Classe, Date> modified;

}