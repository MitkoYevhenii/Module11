package ua.goit.module10.Task4;

import java.util.stream.Stream;

public class LinearCongruentialGenerator {
    private long seed;
    private long a = 25214903917L;
    private long c = 11L;
    private long m = (long) Math.pow(2, 48);

    public LinearCongruentialGenerator() {
        this(System.currentTimeMillis());
    }

    public LinearCongruentialGenerator(long seed) {
        this.seed = seed;
    }

    public LinearCongruentialGenerator(long seed, long a, long c, long m) {
        this(seed);
        this.a = a;
        this.c = c;
        this.m = m;
    }

    public Stream<Long> infinityGenerateRandom() {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public long generateRandom() {
        seed = (a * seed + c) % m;
        return seed;
    }
}


class LinearCongruentialGeneratorTesr {
    public static void main(String[] args) {
        LinearCongruentialGenerator generator = new LinearCongruentialGenerator();

        System.out.println("Генерация через бесконечный поток:");
        generator.infinityGenerateRandom().limit(100).forEach(System.out::println);

        System.out.println("Генерация через стандартную функцию:");
        for (int i = 0; i < 100; i++) {
            System.out.println(generator.generateRandom());
        }

    }
}

