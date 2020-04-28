package com.oc.moko.lade.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = EmailUniqueValidator.class)
@Documented
public @interface EmailUnique {
	
	String message() default "Cette adresse email est déjà utilisée." ;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	String first();

	@Target({ TYPE, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		EmailUnique[] value();
	}
}

//https://www.baeldung.com/spring-mvc-custom-validator
