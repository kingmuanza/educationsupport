package edu.support.entities;

import edu.support.entities.Eleve;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Moratoire.class)
public class Moratoire_ { 

    public static volatile SingularAttribute<Moratoire, String> reponse;
    public static volatile SingularAttribute<Moratoire, Integer> idmoratoire;
    public static volatile SingularAttribute<Moratoire, String> code;
    public static volatile SingularAttribute<Moratoire, Boolean> deleted;
    public static volatile SingularAttribute<Moratoire, Date> created;
    public static volatile SingularAttribute<Moratoire, Date> modified;
    public static volatile SingularAttribute<Moratoire, Integer> etat;
    public static volatile SingularAttribute<Moratoire, Eleve> eleveIdeleve;

}