package ua.goit.module10.Task5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Task5 {
    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(1, 3, 5, 7);
        Stream<Integer> second = Stream.of(2, 4, 6, 8, 10);

        Stream<Integer> mixed = zip(first, second);
        System.out.println(mixed.collect(Collectors.toList()));
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> input1 = first.collect(Collectors.toList());
        List<T> input2 = second.collect(Collectors.toList());

        Iterator<T> itrFirst = input1.iterator();
        Iterator<T> itrSecond = input2.iterator();
        List<T> result = new ArrayList<>();

        while (itrFirst.hasNext() && itrSecond.hasNext()) {
            result.add(itrFirst.next());
            result.add(itrSecond.next());
        }

        return result.stream();
    }
}
