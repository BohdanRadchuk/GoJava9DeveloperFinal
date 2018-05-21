package com.javanine.finalProject.validator;

/**
 * Patterns for validation values of com.javanine.finalProject.dto.* com.javanine.finalProject.model.*
 */

public class RegexpPatterns {
    public static final String PATTERN_STRING_WITH_NUMBERS_LETTERS_AND_DASH ="^\\s*[\\da-zA-Z][\\da-zA-Z\\s][\\d-a-z-A-Z\\s]*$";
    public static final String MESSAGE_STRING_WITH_NUMBERS_LETTERS_AND_DASH ="This field must contains only numbers, letters and dash";

    public static final String PATTERN_NUMBERS ="^[\\0-9][\\0-9.0-9]";
    public static final String MESSAGE_NUMBERS ="This field must contains only numbers and one point";
}