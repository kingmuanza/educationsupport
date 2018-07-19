package edu.support.entities;

import edu.support.entities.Rapport;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Reunion.class)
public class Reunion_ { 

    public static volatile ListAttribute<Reunion, Rapport> rapportList;
    public static volatile SingularAttribute<Reunion, String> code;
    public static volatile SingularAttribute<Reunion, Boolean> deleted;
    public static volatile SingularAttribute<Reunion, Date> dateJour;
    public static volatile SingularAttribute<Reunion, Date> created;
    public static volatile SingularAttribute<Reunion, Date> modified;
    public static volatile SingularAttribute<Reunion, Integer> idreunion;
    public static volatile SingularAttribute<Reunion, Integer> etat;

}