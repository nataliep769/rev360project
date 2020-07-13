package com.example.codingprep;

import java.util.HashMap;
import java.util.Map;

public class ArrayUtility {
    public static int[] coupleSum(int[] numbers, int target) {

        Map<Integer, Integer> numberAndDifference = new HashMap<>();

        int[] result = null;
        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            numberAndDifference.put(target - numbers[i], i + 1);

            if (numberAndDifference.containsKey(numbers[i]) && key != numbers[i])
            {
                result = new int[]{i, i + 1};
            }
        }

        return result;

    }

}
