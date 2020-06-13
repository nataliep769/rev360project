package com.example.livongoquestion;

import java.util.ArrayList;
import java.util.Collections;

public class SearchSubstringUtil {

    public static String findLongestRepeatedSubStringNoOverlap(String fullString) {
        ArrayList<String> substringList = buildSubstringList(fullString);
        String longestRepeatedSubstring = "";

        for (int index = 0; index < substringList.size(); index++) {
            int occurrences = Collections.frequency(substringList, substringList.get(index));
            String substring = substringList.get(index);
            if (substring.length() > longestRepeatedSubstring.length() && occurrences > 1) {
                longestRepeatedSubstring = substring;
            }
        }

        return longestRepeatedSubstring;
    }

    protected static ArrayList<String> buildSubstringList(String fullString) {
        char[] characterList = fullString.toCharArray();

        ArrayList<String> substringList = new ArrayList<>();

        for (int j = characterList.length; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                String substring = fullString.substring(i, j);
                substringList.add(substring);
            }
        }

        return substringList;
    }
}