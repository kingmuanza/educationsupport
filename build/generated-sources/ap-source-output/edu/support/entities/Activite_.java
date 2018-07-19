package edu.support.entities;

import edu.support.entities.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Activite.class)
public class Activite_ { 

    public static volatile SingularAttribute<Activite, Integer> idactivite;
    public static volatile SingularAttribute<Activite, Boolean> deleted;
    public static volatile SingularAttribute<Activite, Date> created;
    public static volatile SingularAttribute<Activite, Integer> action;
    public static volatile SingularAttribute<Activite, Date> modified;
    public static volatile SingularAttribute<Activite, Utilisateur> utilisateurIdutilisateur;

}