package edu.support.entities;

import edu.support.entities.Individu;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Absence.class)
public class Absence_ { 

    public static volatile SingularAttribute<Absence, Integer> idabsence;
    public static volatile SingularAttribute<Absence, Date> jourAbsence;
    public static volatile SingularAttribute<Absence, Boolean> deleted;
    public static volatile SingularAttribute<Absence, Date> created;
    public static volatile SingularAttribute<Absence, Date> modified;
    public static volatile SingularAttribute<Absence, String> motif;
    public static volatile SingularAttribute<Absence, Boolean> justifee;
    public static volatile SingularAttribute<Absence, Individu> individuIdindividu;

}