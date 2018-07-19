package edu.support.entities;

import edu.support.entities.Individu;
import edu.support.entities.Sanction;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Enseignant.class)
public class Enseignant_ { 

    public static volatile SingularAttribute<Enseignant, Integer> idenseignant;
    public static volatile SingularAttribute<Enseignant, Boolean> deleted;
    public static volatile SingularAttribute<Enseignant, Date> created;
    public static volatile ListAttribute<Enseignant, Sanction> sanctionList;
    public static volatile SingularAttribute<Enseignant, Date> modified;
    public static volatile SingularAttribute<Enseignant, Individu> individuIdindividu;

}