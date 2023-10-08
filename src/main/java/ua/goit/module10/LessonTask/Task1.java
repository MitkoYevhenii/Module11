package ua.goit.module10.LessonTask;

import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        final List<String> input = Arrays.asList("Hello", "From", "Ukraine");

        final List<String> result = input.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(result);
    }
}
