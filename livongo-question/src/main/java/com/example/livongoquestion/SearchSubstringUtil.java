package com.example.livongoquestion;

import java.util.ArrayList;
import java.util.Collections;

public class SearchSubstringUtil {

    public static ArrayList<String> buildSubstringList(String fullString) {
        char[] characterList = fullString.toCharArray();

        ArrayList<String> substringList = new ArrayList<>();

        for (int j = characterList.length; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                String substring = fullString.substring(i, j);
                substringList.add(substring);
                // Could add some sort of check like... if substring is already in list, add a count of this substring?
            }
        }

        /*int maxOccurrences = 0;
        int maxSubstringCharacters = 0;
        String maxRepeatedSubstring = "";

        for (int index = 0; index < substringList.size(); index++) {

            int occurrences = Collections.frequency(substringList, substringList.get(index));

            if ((occurrences > maxOccurrences)) {
                if (substringList.get(index).length() > maxSubstringCharacters) {

                    maxOccurrences = occurrences;
                    maxSubstringCharacters = substringList.get(index).length();
                    maxRepeatedSubstring = substringList.get(index);
                }
            }
        }

        System.out.println(maxRepeatedSubstring);
*/
        return substringList;
    }
}