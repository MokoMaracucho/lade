package com.oc.moko.lade.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy=ValidConnectionValidator.class)
@Documented
public @interface ValidConnection {
	
	String message() default "La connection a échouée.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String emailFormConnection();
	String motDePasseFormConnection();

	@Target({ TYPE, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		FieldMatch[] value();
	}
}
