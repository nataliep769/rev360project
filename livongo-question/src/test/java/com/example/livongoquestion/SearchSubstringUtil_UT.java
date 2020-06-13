package com.example.livongoquestion;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;

public class SearchSubstringUtil_UT {

    @Test
    public void buildSubstringList_valid() {
        ArrayList<String> result = SearchSubstringUtil.buildSubstringList("abcc");

        assertThat(result, containsInAnyOrder("a", "ab", "abc", "c", "bc", "b"));
    }

    @Test
    public void findLongestRepeatedSubStringNoOverlap_valid() {
        String result = SearchSubstringUtil.findLongestRepeatedSubStringNoOverlap("eeeeabcabc");

        assertThat(result, is(equalTo("abc")));
    }
}
