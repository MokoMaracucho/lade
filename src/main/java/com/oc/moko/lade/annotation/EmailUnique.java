package com.oc.moko.lade.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=EmailUniqueValidator.class)
public @interface EmailUnique {
	
	String message() default "Cette adresse email est déjà utilisée." ;
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String value();
	
    @Target({ElementType.FIELD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        EmailUnique[] value();
    }
}