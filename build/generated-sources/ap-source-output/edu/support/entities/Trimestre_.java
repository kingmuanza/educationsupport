package edu.support.entities;

import edu.support.entities.Sequence;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Trimestre.class)
public class Trimestre_ { 

    public static volatile SingularAttribute<Trimestre, Boolean> deleted;
    public static volatile SingularAttribute<Trimestre, Integer> numero;
    public static volatile SingularAttribute<Trimestre, Integer> idtrimestre;
    public static volatile SingularAttribute<Trimestre, Date> created;
    public static volatile SingularAttribute<Trimestre, Date> modified;
    public static volatile ListAttribute<Trimestre, Sequence> sequenceList;

}