package edu.support.entities;

import edu.support.entities.ElevesTraduits;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(ConseilDiscipline.class)
public class ConseilDiscipline_ { 

    public static volatile SingularAttribute<ConseilDiscipline, Integer> idconseilDiscipline;
    public static volatile SingularAttribute<ConseilDiscipline, String> code;
    public static volatile SingularAttribute<ConseilDiscipline, Date> dateDebut;
    public static volatile SingularAttribute<ConseilDiscipline, Date> created;
    public static volatile SingularAttribute<ConseilDiscipline, Date> modified;
    public static volatile SingularAttribute<ConseilDiscipline, Date> dateFin;
    public static volatile SingularAttribute<ConseilDiscipline, Boolean> boolean1;
    public static volatile ListAttribute<ConseilDiscipline, ElevesTraduits> elevesTraduitsList;

}