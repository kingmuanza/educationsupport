package edu.support.entities;

import edu.support.entities.Individu;
import edu.support.entities.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(IndividuUtilisateur.class)
public class IndividuUtilisateur_ { 

    public static volatile SingularAttribute<IndividuUtilisateur, Boolean> deleted;
    public static volatile SingularAttribute<IndividuUtilisateur, Integer> idindividuUtilisateur;
    public static volatile SingularAttribute<IndividuUtilisateur, Date> created;
    public static volatile SingularAttribute<IndividuUtilisateur, Date> modified;
    public static volatile SingularAttribute<IndividuUtilisateur, Utilisateur> utilisateurIdutilisateur;
    public static volatile SingularAttribute<IndividuUtilisateur, Individu> individuIdindividu;

}