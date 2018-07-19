package edu.support.entities;

import edu.support.entities.EleveMaladie;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Maladie.class)
public class Maladie_ { 

    public static volatile SingularAttribute<Maladie, Boolean> deleted;
    public static volatile SingularAttribute<Maladie, Date> created;
    public static volatile SingularAttribute<Maladie, String> description;
    public static volatile SingularAttribute<Maladie, String> typeMaladie;
    public static volatile SingularAttribute<Maladie, Date> modified;
    public static volatile SingularAttribute<Maladie, String> nom;
    public static volatile SingularAttribute<Maladie, Integer> idmaladie;
    public static volatile ListAttribute<Maladie, EleveMaladie> eleveMaladieList;

}