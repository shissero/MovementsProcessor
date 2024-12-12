package com.example.vamojossa.utils;

import java.util.regex.Pattern;

public class RegexUtils {

    public static final String date_pattern_str = "(\\d\\d)/(\\d\\d)/(\\d\\d\\d\\d)"; // matches a date
    public static final String float_pattern_str = "(-?\\d+[.]\\d+)";

    public static final Pattern date_pattern = Pattern.compile(date_pattern_str);
    public static final Pattern float_pattern = Pattern.compile(float_pattern_str);

}
