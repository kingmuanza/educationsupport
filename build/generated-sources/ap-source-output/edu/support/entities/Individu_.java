package edu.support.entities;

import edu.support.entities.Absence;
import edu.support.entities.Eleve;
import edu.support.entities.Employe;
import edu.support.entities.Enseignant;
import edu.support.entities.IndividuUtilisateur;
import edu.support.entities.Retard;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Individu.class)
public class Individu_ { 

    public static volatile SingularAttribute<Individu, String> matricule;
    public static volatile SingularAttribute<Individu, Date> dateNaissance;
    public static volatile ListAttribute<Individu, Employe> employeList;
    public static volatile SingularAttribute<Individu, Date> created;
    public static volatile ListAttribute<Individu, Enseignant> enseignantList;
    public static volatile ListAttribute<Individu, Eleve> eleveList;
    public static volatile SingularAttribute<Individu, String> sexe;
    public static volatile SingularAttribute<Individu, String> telephone;
    public static volatile SingularAttribute<Individu, Integer> idindividu;
    public static volatile SingularAttribute<Individu, String> prenoms;
    public static volatile SingularAttribute<Individu, String> lieuNaissance;
    public static volatile ListAttribute<Individu, Absence> absenceList;
    public static volatile SingularAttribute<Individu, Boolean> deleted;
    public static volatile SingularAttribute<Individu, String> noms;
    public static volatile ListAttribute<Individu, Retard> retardList;
    public static volatile ListAttribute<Individu, IndividuUtilisateur> individuUtilisateurList;
    public static volatile SingularAttribute<Individu, Date> modified;
    public static volatile SingularAttribute<Individu, String> residence;
    public static volatile SingularAttribute<Individu, String> email;

}