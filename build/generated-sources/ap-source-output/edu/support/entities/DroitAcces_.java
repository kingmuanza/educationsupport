package edu.support.entities;

import edu.support.entities.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(DroitAcces.class)
public class DroitAcces_ { 

    public static volatile SingularAttribute<DroitAcces, Boolean> deleted;
    public static volatile SingularAttribute<DroitAcces, Date> created;
    public static volatile SingularAttribute<DroitAcces, String> description;
    public static volatile SingularAttribute<DroitAcces, Date> modified;
    public static volatile SingularAttribute<DroitAcces, Integer> niveau;
    public static volatile SingularAttribute<DroitAcces, Integer> iddroitAcces;
    public static volatile ListAttribute<DroitAcces, Utilisateur> utilisateurList;

}