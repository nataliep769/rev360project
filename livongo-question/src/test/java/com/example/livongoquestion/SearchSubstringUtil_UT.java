package com.example.livongoquestion;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;

public class SearchSubstringUtil_UT {

    @Test
    public void buildSubstringList_valid() {
        ArrayList<String> result = SearchSubstringUtil.buildSubstringList("abc");

        assertThat(result, containsInAnyOrder("a", "ab", "abc", "b", "bc", "c"));
    }

    @Test
    public void findLongestRepeatedSubStringNoOverlap_valid() {
        String result = SearchSubstringUtil.findLongestRepeatedSubStringNoOverlap("aabaabaaba");

        assertThat(result, is(equalTo("aaba")));
    }

    @Test
    public void findLongestRepeatedSubStringNoOverlapa_valid() {
        String result = SearchSubstringUtil.findLongestRepeatedSubStringNoOverlap("nataliehinatalie");

        assertThat(result, is(equalTo("natalie")));
    }
}
