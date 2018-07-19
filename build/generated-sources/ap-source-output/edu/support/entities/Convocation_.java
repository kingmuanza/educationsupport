package edu.support.entities;

import edu.support.entities.Eleve;
import edu.support.entities.Employe;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Convocation.class)
public class Convocation_ { 

    public static volatile SingularAttribute<Convocation, Boolean> deleted;
    public static volatile SingularAttribute<Convocation, Date> created;
    public static volatile SingularAttribute<Convocation, Date> modified;
    public static volatile SingularAttribute<Convocation, Employe> employeIdemploye;
    public static volatile SingularAttribute<Convocation, String> motif;
    public static volatile SingularAttribute<Convocation, Integer> idconvocation;
    public static volatile SingularAttribute<Convocation, Eleve> eleveIdeleve;

}