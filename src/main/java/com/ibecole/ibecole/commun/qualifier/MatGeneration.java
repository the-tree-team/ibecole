package com.ibecole.ibecole.commun.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by TOSHIBA on 12/12/2018.
 */
@Qualifier
@Target({ElementType.FIELD, ElementType.PARAMETER,ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MatGeneration {
    public enum typeMat{
        ELEVE,
        PARENT,
        PROFESSEUR
    }
    typeMat value();

}
