package com.example.livongoquestion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchSubstringUtil_UT {

    @Test
    public void buildSubstringList_valid() {
        ArrayList<String> result = SearchSubstringUtil.buildSubstringList("abc");

        assertThat(result, containsInAnyOrder("a", "ab", "abc", "b", "bc", "c"));
    }

    @ParameterizedTest
    @MethodSource("findLongestRepeatedSubstringArgs")
    public void findLongestRepeatedSubStringNoOverlap(
            String fullString,
            String expectedSubstring
    ) {
        assertThat(
                SearchSubstringUtil.findLongestRepeatedSubStringNoOverlap(fullString),
                is(equalTo(expectedSubstring))
        );
    }

    @Test
    public void hasOverlap_substringLongerThanIndexRange() {
        // GIVEN
        ArrayList<Integer> fromIndexes = new ArrayList<>(Arrays.asList(0, 3));
        String substring = "beep";

        // WHEN
        boolean result = SearchSubstringUtil.hasOverlap(fromIndexes, 0, substring);

        // EXPECT
        assertThat(result, is(equalTo(true)));
    }

    @Test
    public void hasOverlap_substringShorterThanIndexRange() {
        // GIVEN
        ArrayList<Integer> fromIndexes = new ArrayList<>(Arrays.asList(0, 3));
        String substring = "ba";

        // WHEN
        boolean result = SearchSubstringUtil.hasOverlap(fromIndexes, 0, substring);

        // EXPECT
        assertThat(result, is(equalTo(false)));
    }

    @Test
    public void buildFromIndexList() {
        // WHEN
        ArrayList<Integer> fromIndexes = SearchSubstringUtil.buildFromIndexList(3, "heyheyhey", "hey");

        // EXPECT
        assertThat(fromIndexes, is(equalTo(Arrays.asList(0, 3, 6))));
    }

    private static Stream<Arguments> findLongestRepeatedSubstringArgs() {
        return Stream.of(
                Arguments.of("aabaabaaba", "aaba"),
                Arguments.of("nataliehinatalie", "natalie"),
                Arguments.of("banana", "na")
        );
    }
}
