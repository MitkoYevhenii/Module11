package ua.goit.module10.LessonTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Task3 {
    public static void main(String[] args) {
        List<List<String>> input = asList(asList("Biba", "Boba"), asList("Bebra", "Bobma"));

        //without stream api
        List<String> result1 = new ArrayList<>();
        for (List<String> innerList : input) {
            result1.addAll(innerList);
        }

        System.out.println("Result w/o stream api : " + result1);

        List<String> resultStreamApi = input.stream()
                .flatMap(Collection::stream)
                .toList();

        System.out.println("Result with stream api : " + resultStreamApi);
    }
}
