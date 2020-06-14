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

            if (occurrences > 1) {
                ArrayList<Integer> indexes = new ArrayList<>();
                int fromIndex = -1;
                for (int i = 0; i <= occurrences; i++) {
                    fromIndex = fullString.indexOf(substring, fromIndex + 1);
                    indexes.add(fromIndex);
                    // when -1 is returned, it means there is not another index
                    // when the distance between two
                    fromIndex = fromIndex + 1;
                }
            }

            if (substring.length() > longestRepeatedSubstring.length() && occurrences > 1) {
                longestRepeatedSubstring = substring;
            }

            // Could collect the ones that have more than one occurrence
        }

        // Maybe need to keep a list of all the indexes?

        // (0, 3) (3, 6) (6, 9)
        // This overlaps with two... we should have two instances in total
        /// say our test input is aabaabaaba
        // should return aaba

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