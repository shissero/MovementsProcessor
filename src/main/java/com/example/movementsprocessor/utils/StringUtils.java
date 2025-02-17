package com.example.movementsprocessor.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static List<String> split(String str, String regex){

        return new ArrayList<>(
                Arrays.asList(str.split(regex)) // Arrays.asList returns an immutable list, so we have to create a mutable list from it
        );
    }
}
