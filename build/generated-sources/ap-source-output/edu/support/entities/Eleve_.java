package edu.support.entities;

import edu.support.entities.AutorisationSortie;
import edu.support.entities.Classe;
import edu.support.entities.Convocation;
import edu.support.entities.EleveMaladie;
import edu.support.entities.ElevesTraduits;
import edu.support.entities.Individu;
import edu.support.entities.Moratoire;
import edu.support.entities.Note;
import edu.support.entities.Paiement;
import edu.support.entities.PassageInfirmerie;
import edu.support.entities.Relance;
import edu.support.entities.Sanction;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Eleve.class)
public class Eleve_ { 

    public static volatile ListAttribute<Eleve, Moratoire> moratoireList;
    public static volatile SingularAttribute<Eleve, Integer> ideleve;
    public static volatile SingularAttribute<Eleve, Date> created;
    public static volatile ListAttribute<Eleve, Note> noteList;
    public static volatile ListAttribute<Eleve, Convocation> convocationList;
    public static volatile ListAttribute<Eleve, ElevesTraduits> elevesTraduitsList;
    public static volatile SingularAttribute<Eleve, Boolean> deleted;
    public static volatile ListAttribute<Eleve, AutorisationSortie> autorisationSortieList;
    public static volatile ListAttribute<Eleve, Relance> relanceList;
    public static volatile ListAttribute<Eleve, Sanction> sanctionList;
    public static volatile SingularAttribute<Eleve, Date> modified;
    public static volatile ListAttribute<Eleve, Paiement> paiementList;
    public static volatile ListAttribute<Eleve, PassageInfirmerie> passageInfirmerieList;
    public static volatile SingularAttribute<Eleve, Classe> classeIdclasse;
    public static volatile SingularAttribute<Eleve, Individu> individuIdindividu;
    public static volatile ListAttribute<Eleve, EleveMaladie> eleveMaladieList;

}