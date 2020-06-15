package com.example.livongoquestion;

import java.util.ArrayList;
import java.util.Collections;

public class SearchSubstringUtil {

    public static String findLongestRepeatedSubStringNoOverlap(String fullString) {
        ArrayList<String> substringList = buildSubstringList(fullString);
        String longestRepeatedSubstring = "";

        for (int index = 0; index < substringList.size(); index++) {
            String substring = substringList.get(index);
            int occurrences = Collections.frequency(substringList, substring);
            int occurrencesWithoutOverlap = 0;

            if (occurrences > 1) {
                ArrayList<Integer> fromIndexes = buildFromIndexList(occurrences, fullString, substring);
                occurrencesWithoutOverlap = subtractOccurrenceWhenOverlap(fromIndexes, substring, occurrences);
            }

            if (occurrencesWithoutOverlap > 1) {
                longestRepeatedSubstring = compareLengthsOfSubstrings(substring, longestRepeatedSubstring);
            }
        }

        return longestRepeatedSubstring;
    }

    protected static String compareLengthsOfSubstrings(String substring, String longestRepeatedSubstring) {
        if (substring.length() > longestRepeatedSubstring.length()) {
            longestRepeatedSubstring = substring;
        } else if (substring.length() == longestRepeatedSubstring.length()) {
            if (!substring.equals(longestRepeatedSubstring)) {
                longestRepeatedSubstring = substring + " or " + longestRepeatedSubstring;
            }
        }

        return longestRepeatedSubstring;
    }

    protected static ArrayList<Integer> buildFromIndexList(
            int occurrences,
            String fullString,
            String substring
    ) {
        ArrayList<Integer> fromIndexes = new ArrayList<>();
        int fromIndex = -1;
        for (int i = 0; i < occurrences; i++) {
            fromIndex = fullString.indexOf(substring, fromIndex + 1);
            fromIndexes.add(fromIndex);
            fromIndex++;
        }

        return fromIndexes;
    }

    //TODO: Need to account for the case of "aaaaaaaa"
    protected static int subtractOccurrenceWhenOverlap(
            ArrayList<Integer> fromIndexes,
            String substring,
            int occurrences
    ) {
        for (int j = 0; j < fromIndexes.size() - 1; j++) {
            if ((hasOverlap(fromIndexes, j, substring))) {
                occurrences = occurrences - 1;
                j++;
            }
        }

        return occurrences;
    }

    protected static boolean hasOverlap(ArrayList<Integer> fromIndexes, int index, String substring) {
        return (fromIndexes.get(index + 1) - fromIndexes.get(index)) < substring.length();
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