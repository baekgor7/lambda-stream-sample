package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class StreamTest5 {

    public static void main(String[] args) {

        IntStream intStream = Arrays.stream(new int[] {5, 4, 3, 1, 6, 2});
        intStream
                .sorted()
                .forEach(n -> System.out.println(n));

        List<Student> studentList = Arrays.asList(
                new Student("홍길동", "남성", 99),
                new Student("임꺽정", "남성", 95),
                new Student("이민정", "여성", 90),
                new Student("송혜교", "여성", 94),
                new Student("가나다", "남성", 88),
                new Student("라마바", "남성", 77)
        );

        System.out.println("=====================");

        studentList.stream()
                .sorted()
                .forEach(s -> System.out.println(s.getScore()));

        System.out.println("=====================");

        studentList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.println(s.getScore()));

    }

}
