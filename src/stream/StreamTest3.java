package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest3 {

    public static void main(String[] args) {

        //풀어쓴 내용
        Stream<Student> stream = list.stream();
        Stream<Student> manStream = stream.filter(s -> s.getSex().equals("남성"));
        IntStream scoreStream = manStream.mapToInt(s -> s.getScore());
        OptionalDouble optionalDouble = scoreStream.average();
        double avg = optionalDouble.getAsDouble();
        System.out.println(avg);

        //스트림 파이프라인
        double scoreAvg = list.stream()
                .filter(s -> s.getSex().equals("남성"))
                .mapToInt(s -> s.getScore())
                .average()
                .getAsDouble();

        System.out.println(scoreAvg);
    }

    private static List<Student> list = Arrays.asList(
            new Student("홍길동", "남성", 99),
            new Student("임꺽정", "남성", 95),
            new Student("이민정", "여성", 90),
            new Student("송혜교", "여성", 94),
            new Student("소나무", "남성", 100)
    );

}
