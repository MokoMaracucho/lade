package com.oc.moko.lade.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.oc.moko.lade.annotation.FieldMatchValidator;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy=FieldMatchValidator.class)
@Documented
public @interface FieldMatch {
	
	String message() default "Les mots-de-passe doivent être identiques.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String motDePasseUtilisateur();
	String confirmationMotDePasseUtilisateur();

	@Target({ TYPE, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		FieldMatch[] value();
	}
}