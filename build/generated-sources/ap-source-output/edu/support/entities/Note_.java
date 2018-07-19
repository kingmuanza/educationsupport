package edu.support.entities;

import edu.support.entities.Eleve;
import edu.support.entities.Evaluation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Note.class)
public class Note_ { 

    public static volatile SingularAttribute<Note, Boolean> deleted;
    public static volatile SingularAttribute<Note, Double> valeur;
    public static volatile SingularAttribute<Note, Date> created;
    public static volatile SingularAttribute<Note, Date> modified;
    public static volatile SingularAttribute<Note, Evaluation> evaluationIdevaluation;
    public static volatile SingularAttribute<Note, Integer> idnote;
    public static volatile SingularAttribute<Note, Eleve> eleveIdeleve;

}