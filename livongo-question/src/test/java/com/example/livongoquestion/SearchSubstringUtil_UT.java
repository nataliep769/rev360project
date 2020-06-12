package com.example.livongoquestion;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;

public class SearchSubstringUtil_UT {

    @Test
    public void findMaxRepeat_valid() {
        ArrayList<String> result = SearchSubstringUtil.buildSubstringList("abc");

        assertThat(result, containsInAnyOrder("a", "ab", "abc", "c", "bc", "b"));
    }
}
