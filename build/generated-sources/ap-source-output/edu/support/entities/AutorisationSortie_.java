package edu.support.entities;

import edu.support.entities.Eleve;
import edu.support.entities.Employe;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(AutorisationSortie.class)
public class AutorisationSortie_ { 

    public static volatile SingularAttribute<AutorisationSortie, String> code;
    public static volatile SingularAttribute<AutorisationSortie, Date> deleted;
    public static volatile SingularAttribute<AutorisationSortie, Date> dateJour;
    public static volatile SingularAttribute<AutorisationSortie, Date> created;
    public static volatile SingularAttribute<AutorisationSortie, Date> modified;
    public static volatile SingularAttribute<AutorisationSortie, Employe> employeIdemploye;
    public static volatile SingularAttribute<AutorisationSortie, Integer> idautorisationSortie;
    public static volatile SingularAttribute<AutorisationSortie, Eleve> eleveIdeleve;

}