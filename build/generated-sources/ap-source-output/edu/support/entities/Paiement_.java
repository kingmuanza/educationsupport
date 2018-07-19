package edu.support.entities;

import edu.support.entities.Eleve;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Paiement.class)
public class Paiement_ { 

    public static volatile SingularAttribute<Paiement, String> code;
    public static volatile SingularAttribute<Paiement, Boolean> deleted;
    public static volatile SingularAttribute<Paiement, Date> dateJour;
    public static volatile SingularAttribute<Paiement, Date> created;
    public static volatile SingularAttribute<Paiement, Date> modified;
    public static volatile SingularAttribute<Paiement, Double> montant;
    public static volatile SingularAttribute<Paiement, Integer> idpaiement;
    public static volatile SingularAttribute<Paiement, Eleve> eleveIdeleve;

}