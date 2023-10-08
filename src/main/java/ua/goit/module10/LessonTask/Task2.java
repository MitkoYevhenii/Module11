package ua.goit.module10.LessonTask;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Task2 {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("Do", "You", "SSS", "rang", "fighter");

        List<String> result = input.stream()
                .filter(word -> word.length() < 4)
                .toList();

        System.out.println(result);
    }
}
