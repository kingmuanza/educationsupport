package edu.support.entities;

import edu.support.entities.Classe;
import edu.support.entities.Matiere;
import edu.support.entities.Note;
import edu.support.entities.Sequence;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-16T16:12:14")
@StaticMetamodel(Evaluation.class)
public class Evaluation_ { 

    public static volatile SingularAttribute<Evaluation, Sequence> sequenceIdsequence;
    public static volatile SingularAttribute<Evaluation, Matiere> matiereIdmatiere;
    public static volatile SingularAttribute<Evaluation, Integer> idevaluation;
    public static volatile ListAttribute<Evaluation, Note> noteList;
    public static volatile SingularAttribute<Evaluation, Classe> classeIdclasse;

}