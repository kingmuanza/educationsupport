package edu.support.entities;

import edu.support.entities.Activite;
import edu.support.entities.DroitAcces;
import edu.support.entities.IndividuUtilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile SingularAttribute<Utilisateur, Integer> idutilisateur;
    public static volatile SingularAttribute<Utilisateur, String> motDePasse;
    public static volatile SingularAttribute<Utilisateur, DroitAcces> droitAccesIddroitAcces;
    public static volatile ListAttribute<Utilisateur, Activite> activiteList;
    public static volatile SingularAttribute<Utilisateur, Boolean> deleted;
    public static volatile SingularAttribute<Utilisateur, Date> created;
    public static volatile ListAttribute<Utilisateur, IndividuUtilisateur> individuUtilisateurList;
    public static volatile SingularAttribute<Utilisateur, Date> modified;
    public static volatile SingularAttribute<Utilisateur, String> login;

}