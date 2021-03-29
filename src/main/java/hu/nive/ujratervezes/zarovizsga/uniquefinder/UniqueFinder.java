package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueFinder {
    public List<Character> uniqueChars(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input is null");
        }
//        return text.chars()
//                .mapToObj(c->(char)c)
//                .distinct()
//                .collect(Collectors.toList());

        List<Character> result = new ArrayList<>();
        for (Character c : text.toCharArray()) {
            if (!result.contains(c)) {
                result.add(c);
            }
        }
        return result;
    }
}
