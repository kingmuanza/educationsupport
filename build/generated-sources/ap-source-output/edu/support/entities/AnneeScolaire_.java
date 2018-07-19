package edu.support.entities;

import edu.support.entities.Sequence;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(AnneeScolaire.class)
public class AnneeScolaire_ { 

    public static volatile SingularAttribute<AnneeScolaire, Integer> idanneeScolaire;
    public static volatile SingularAttribute<AnneeScolaire, Boolean> deleted;
    public static volatile SingularAttribute<AnneeScolaire, String> dateDebut;
    public static volatile SingularAttribute<AnneeScolaire, Date> created;
    public static volatile SingularAttribute<AnneeScolaire, Date> modified;
    public static volatile SingularAttribute<AnneeScolaire, String> dateFin;
    public static volatile SingularAttribute<AnneeScolaire, Boolean> enCours;
    public static volatile ListAttribute<AnneeScolaire, Sequence> sequenceList;

}