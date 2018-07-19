package edu.support.entities;

import edu.support.entities.Eleve;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Relance.class)
public class Relance_ { 

    public static volatile SingularAttribute<Relance, Boolean> deleted;
    public static volatile SingularAttribute<Relance, Date> created;
    public static volatile SingularAttribute<Relance, Date> modified;
    public static volatile SingularAttribute<Relance, Double> montant;
    public static volatile SingularAttribute<Relance, Integer> idrelance;
    public static volatile SingularAttribute<Relance, String> motif;
    public static volatile SingularAttribute<Relance, Date> echeance;
    public static volatile SingularAttribute<Relance, Eleve> eleveIdeleve;

}