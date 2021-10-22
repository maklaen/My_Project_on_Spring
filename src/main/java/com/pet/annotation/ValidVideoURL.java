package com.pet.annotation;

import com.pet.validation.VideoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VideoValidator.class)
@Documented
public @interface ValidVideoURL {
    String message() default "Invalid video URL";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default {};
}
