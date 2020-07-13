package com.example.codingprep;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StringUtility_UT {

    @Test
    public void buildSubstringList() {
        ArrayList<String> result = StringUtility.buildSubstringList("abc");

        assertThat(result, containsInAnyOrder("a", "ab", "abc", "b", "bc", "c"));
    }

    @ParameterizedTest
    @MethodSource("findLongestRepeatedSubstringArgs")
    public void findLongestRepeatedSubStringNoOverlap(
            String fullString,
            String expectedSubstring
    ) {
        assertThat(
                StringUtility.findLongestRepeatedSubStringNoOverlap(fullString),
                is(equalTo(expectedSubstring))
        );
    }

    @Test
    public void hasOverlap_substringLongerThanIndexRange() {
        // GIVEN
        ArrayList<Integer> fromIndexes = new ArrayList<>(Arrays.asList(0, 3));
        String substring = "beep";

        // WHEN
        boolean result = StringUtility.hasOverlap(fromIndexes, 0, substring);

        // EXPECT
        assertThat(result, is(equalTo(true)));
    }

    @Test
    public void hasOverlap_substringShorterThanIndexRange() {
        // GIVEN
        ArrayList<Integer> fromIndexes = new ArrayList<>(Arrays.asList(0, 3));
        String substring = "ba";

        // WHEN
        boolean result = StringUtility.hasOverlap(fromIndexes, 0, substring);

        // EXPECT
        assertThat(result, is(equalTo(false)));
    }

    @Test
    public void buildFromIndexList() {
        // WHEN
        ArrayList<Integer> fromIndexes = StringUtility.buildFromIndexList(3, "heyheyhey", "hey");

        // EXPECT
        assertThat(fromIndexes, is(equalTo(Arrays.asList(0, 3, 6))));
    }

    @ParameterizedTest
    @MethodSource("compareLengthsOfSubstringsArgs")
    public void compareLengthsOfSubstrings(
            String existingLongestSubstring,
            String substring,
            String expected
    ) {
        assertThat(
                StringUtility.compareLengthsOfSubstrings(existingLongestSubstring, substring),
                is(equalTo(expected))
        );
    }

    private static Stream<Arguments> compareLengthsOfSubstringsArgs() {
        return Stream.of(
                Arguments.of("hi", "hello", "hello"),
                Arguments.of("hellothere", "hello", "hellothere"),
                Arguments.of("howdy", "howdy", "howdy"),
                Arguments.of("howdy", "hello", "howdy or hello")
        );
    }

    private static Stream<Arguments> findLongestRepeatedSubstringArgs() {
        return Stream.of(
                Arguments.of("aabaabaaba", "aaba"),
                Arguments.of("nataliehinatalie", "natalie"),
                Arguments.of("banana", "an or na")
        );
    }

    @Test
    public void areAllCharactersUnique() {
        StringUtility.areAllCharactersUnique("123!@");
    }

    @Test
    public void replace() {
        StringUtility.replace("This is a test", "meep");
    }

    @Test
    public void binarySearch() {
        StringUtility.binarySearch(new int[]{5,6,7,8,9}, 9);
    }

    @Test
    public void selectionSortArray() {
        StringUtility.selectionSortArray(new int[]{9,4,-1,3,20});
    }

    @Test
    public void isIsomorphic() {
        StringUtility.isIsomorphic("Kendall", "Bfacwzz");
    }
}
