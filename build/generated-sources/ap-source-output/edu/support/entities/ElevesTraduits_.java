package edu.support.entities;

import edu.support.entities.ConseilDiscipline;
import edu.support.entities.Eleve;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(ElevesTraduits.class)
public class ElevesTraduits_ { 

    public static volatile SingularAttribute<ElevesTraduits, Integer> idelevesTraduits;
    public static volatile SingularAttribute<ElevesTraduits, ConseilDiscipline> conseilDisciplineIdconseilDiscipline;
    public static volatile SingularAttribute<ElevesTraduits, String> motif;
    public static volatile SingularAttribute<ElevesTraduits, Eleve> eleveIdeleve;

}