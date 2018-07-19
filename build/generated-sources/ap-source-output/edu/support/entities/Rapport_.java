package edu.support.entities;

import edu.support.entities.Reunion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Rapport.class)
public class Rapport_ { 

    public static volatile SingularAttribute<Rapport, String> code;
    public static volatile SingularAttribute<Rapport, Boolean> deleted;
    public static volatile SingularAttribute<Rapport, Reunion> reunionIdreunion;
    public static volatile SingularAttribute<Rapport, Integer> idrapport;
    public static volatile SingularAttribute<Rapport, Date> created;
    public static volatile SingularAttribute<Rapport, Date> modified;
    public static volatile SingularAttribute<Rapport, String> nomFichier;
    public static volatile SingularAttribute<Rapport, String> url;

}