package edu.support.entities;

import edu.support.entities.AnneeScolaire;
import edu.support.entities.Evaluation;
import edu.support.entities.Trimestre;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Sequence.class)
public class Sequence_ { 

    public static volatile SingularAttribute<Sequence, String> code;
    public static volatile SingularAttribute<Sequence, Boolean> deleted;
    public static volatile SingularAttribute<Sequence, Integer> numero;
    public static volatile SingularAttribute<Sequence, Date> created;
    public static volatile SingularAttribute<Sequence, Integer> idsequence;
    public static volatile SingularAttribute<Sequence, AnneeScolaire> anneeScolaireIdanneeScolaire;
    public static volatile ListAttribute<Sequence, Evaluation> evaluationList;
    public static volatile SingularAttribute<Sequence, Date> modified;
    public static volatile SingularAttribute<Sequence, Trimestre> trimestreIdtrimestre;

}