package edu.support.entities;

import edu.support.entities.Eleve;
import edu.support.entities.Employe;
import edu.support.entities.Enseignant;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Sanction.class)
public class Sanction_ { 

    public static volatile SingularAttribute<Sanction, Boolean> deleted;
    public static volatile SingularAttribute<Sanction, Date> created;
    public static volatile SingularAttribute<Sanction, Enseignant> enseignantIdenseignant;
    public static volatile SingularAttribute<Sanction, String> description;
    public static volatile SingularAttribute<Sanction, Date> modified;
    public static volatile SingularAttribute<Sanction, Employe> employeIdemploye;
    public static volatile SingularAttribute<Sanction, String> motif;
    public static volatile SingularAttribute<Sanction, Integer> idsanction;
    public static volatile SingularAttribute<Sanction, Eleve> eleveIdeleve;

}