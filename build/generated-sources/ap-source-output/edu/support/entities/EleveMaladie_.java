package edu.support.entities;

import edu.support.entities.Eleve;
import edu.support.entities.Maladie;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(EleveMaladie.class)
public class EleveMaladie_ { 

    public static volatile SingularAttribute<EleveMaladie, Boolean> deleted;
    public static volatile SingularAttribute<EleveMaladie, Maladie> maladieIdmaladie;
    public static volatile SingularAttribute<EleveMaladie, Date> created;
    public static volatile SingularAttribute<EleveMaladie, Date> modified;
    public static volatile SingularAttribute<EleveMaladie, Integer> ideleveMaladie;
    public static volatile SingularAttribute<EleveMaladie, Eleve> eleveIdeleve;

}