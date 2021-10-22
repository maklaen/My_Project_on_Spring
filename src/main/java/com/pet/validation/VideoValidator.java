package com.pet.validation;

import com.pet.annotation.ValidVideoURL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoValidator implements ConstraintValidator<ValidVideoURL, String> {
    private static final String URL_PATTERN = "http(?:s?):\\/\\/(?:www\\.)?youtu(?:be\\.com\\/watch\\?v=|\\.be\\/)([\\w\\-\\_]*)(&(amp;)?[\\w\\?=]*)?";

    @Override
    public void initialize(ValidVideoURL constraintAnnotation) {}

    @Override
    public boolean isValid(String videoUrl, ConstraintValidatorContext constraintValidatorContext) {
        return (validVideoURL(videoUrl));
    }

    private boolean validVideoURL(String videoUrl) {
        Pattern pattern = Pattern.compile(URL_PATTERN);
        Matcher matcher = pattern.matcher(videoUrl);
        return matcher.matches();
    }
}
