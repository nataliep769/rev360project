package com.example.codingprep;

import java.util.*;

public class StringUtility {

    /*
     * Finds the longest, repeated substring that does not overlap with another substring in a string
     */
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

    public static boolean areAllCharactersUnique(String str) {

        if (str != null) {

            char[] characterArray = str.toCharArray();

            for (int i = 0; i < characterArray.length; i++) {
                for (int j = 1; j < characterArray.length; j++) {
                    if (characterArray[i] == characterArray[j] && (i != j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static Boolean binarySearch(int[] arr, int n) {

        if (arr != null && arr.length > 0) {
            int low = 0;
            int high = arr.length - 1;
            int middle = high / 2;

            while (high - low > 1) {
                if (n < arr[middle]) {
                    high = middle;
                    middle = (high + low) / 2;
                } else if (n > arr[middle]) {
                    low = middle;
                    middle = (high + low) / 2;
                } else {
                    return true;
                }
            }
            return n == arr[high] || n == arr[low];
        }

        return false;
    }

    public static String replace(String a, String b) {

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Character> chars = new ArrayList<Character>();
        for (char c : a.toCharArray()) {
            chars.add(c);
        }

        for (Character aChar : chars) {
            if (aChar == (' ')) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append(aChar);
            }
        }

        return stringBuilder.toString();
    }

    public static int[] selectionSortArray(int[] arr) {

        int head = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= head; j--) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            head = head + 1;
        }

        return arr;
    }

    public static boolean isIsomorphic(String input1, String input2) {

        char[] characterArray1 = input1.toCharArray();
        char[] characterArray2 = input2.toCharArray();

        Map<Character, List<Integer>> map1 = new LinkedHashMap<>();
        Map<Character, List<Integer>> map2 = new LinkedHashMap<>();

        if (characterArray1.length == 0 && characterArray2.length == 0) {
            return true;
        }

        for (int i = 0; i < characterArray1.length; i++) {

            if (map1.get(characterArray1[i]) == null) {
                map1.put(characterArray1[i], new ArrayList<Integer>(Collections.singleton(i)));
            } else {
                map1.get(characterArray1[i]).add(i);
            }

            if (map2.get(characterArray2[i]) == null) {
                map2.put(characterArray2[i], new ArrayList<Integer>(Collections.singleton(i)));
            } else {
                map2.get(characterArray2[i]).add(i);
            }
        }

        Collection<List<Integer>> listValuesLists1 = map1.values();
        Collection<List<Integer>> listValuesList2 = map2.values();

        return listValuesLists1.equals(listValuesList2);
    }

}