package edu.support.entities;

import edu.support.entities.AutorisationSortie;
import edu.support.entities.Convocation;
import edu.support.entities.Individu;
import edu.support.entities.Sanction;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Employe.class)
public class Employe_ { 

    public static volatile SingularAttribute<Employe, Boolean> deleted;
    public static volatile ListAttribute<Employe, AutorisationSortie> autorisationSortieList;
    public static volatile SingularAttribute<Employe, Integer> idemploye;
    public static volatile SingularAttribute<Employe, Date> created;
    public static volatile ListAttribute<Employe, Sanction> sanctionList;
    public static volatile SingularAttribute<Employe, Date> modified;
    public static volatile ListAttribute<Employe, Convocation> convocationList;
    public static volatile SingularAttribute<Employe, Individu> individuIdindividu;

}