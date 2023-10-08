package ua.goit.module10.Task1_3;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMethods {
    public static String unpairedNames(List<String> list) {
        return IntStream.range(0, list.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> (i + 1) + ". " + list.get(i))
                .collect(Collectors.joining(", "));
    }

    public static List<String> toUpperCaseNames(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static String sortIntegerList(List<String> list) {
        List<Integer> sortedIntegers  = list.stream()
                .flatMap(word -> Arrays.stream(word.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        return sortedIntegers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}

class StreamMethodsTest {
    public static void main(String[] args) {
        int numberRandomWords = 100;
        List<String> worldList = generateRandomWords(numberRandomWords);

        System.out.print("Масив слів до обробки: ");
        for (String world : worldList) {
            System.out.print(world.concat(" "));
        }

        System.out.print("\nРядок який ми отримали зараз: ");
        System.out.print(StreamMethods.unpairedNames(worldList));

        System.out.print("\nМасив слів у верхньому регістрі: ");
        for (String world : StreamMethods.toUpperCaseNames(worldList)) {
            System.out.print(world.concat(" "));
        }


        List<String> integerList = Arrays.asList("1, 2, 0", "4, 5", "-3, 4");

        System.out.print("\nНеотсортированный массив чисел: ");
        for (int i = 0; i < integerList.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print("\"" + integerList.get(i) + "\"");
        }

        System.out.println("\nОтсортированый массив чисел: ".concat(StreamMethods.sortIntegerList(integerList)));
        System.out.println();

    }

    public static List<String> generateRandomWords(int n) {
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String randomWord = RandomStringUtils.randomAlphabetic(8); // Генерировать случайное слово из букв длиной 8 символов
            wordList.add(randomWord);
        }
        return wordList;
    }
}
