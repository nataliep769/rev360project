package com.example.livongoquestion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class SearchSubstringUtil {

    public static String findLongestRepeatedSubStringNoOverlap(String fullString) {
        ArrayList<String> substringList = buildSubstringList(fullString);
        String longestRepeatedSubstring = "";

        for (int index = 0; index < substringList.size(); index++) {
            int occurrences = Collections.frequency(substringList, substringList.get(index));
            String substring = substringList.get(index);
            // In this whole for loop, we are only looking at one substring at a time

            if (occurrences > 1) {
                ArrayList<Integer> indexes = new ArrayList<>();
                int fromIndex = -1;
                for (int i = 0; i < occurrences; i++) {
                    fromIndex = fullString.indexOf(substring, fromIndex + 1);
                    indexes.add(fromIndex);
                    // when -1 is returned, it means there is not another index
                    // when the distance between two indices is less than the length, subtract one from the
                    // occurrences and then add one to the iteration so as to skip the next iteration...
                    fromIndex++;
                }

                for (int j = 0; j < indexes.size() - 1; j++) {
                    if ((indexes.get(j + 1) - indexes.get(j)) < substring.length()) {
                        occurrences = occurrences - 1;
                        j++;
                    }
                }
            }

            if (substring.length() > longestRepeatedSubstring.length() && occurrences > 1) {
                longestRepeatedSubstring = substring;
            }

            // Could collect the ones that have more than one occurrence
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