package edu.support.entities;

import edu.support.entities.Evaluation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Matiere.class)
public class Matiere_ { 

    public static volatile SingularAttribute<Matiere, String> code;
    public static volatile SingularAttribute<Matiere, Boolean> deleted;
    public static volatile SingularAttribute<Matiere, Date> created;
    public static volatile SingularAttribute<Matiere, String> libelle;
    public static volatile SingularAttribute<Matiere, Integer> coefficient;
    public static volatile ListAttribute<Matiere, Evaluation> evaluationList;
    public static volatile SingularAttribute<Matiere, Date> modified;
    public static volatile SingularAttribute<Matiere, Integer> idmatiere;

}