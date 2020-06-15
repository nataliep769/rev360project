package com.example.livongoquestion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
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

    private static Stream<Arguments> findLongestRepeatedSubstringArgs() {
        return Stream.of(
                Arguments.of("aabaabaaba", "aaba"),
                Arguments.of("nataliehinatalie", "natalie"),
                Arguments.of("banana", "na")
        );
    }
}
