package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class StreamTest6 {

    public static void main(String[] args) {


        long count = Arrays.stream(new int[] {5, 4, 3, 1, 6, 2})
                        .filter(n -> n % 2 == 0)
                        .count();
        System.out.println(count);

        System.out.println("=====================");

        long sum = Arrays.stream(new int[] {5, 4, 3, 1, 6, 2})
                        .filter(n -> n % 2 == 0)
                        .sum();
        System.out.println(sum);

        System.out.println("=====================");

        int max = Arrays.stream(new int[] {5, 4, 3, 1, 6, 2})
                        .filter(n -> n % 2 == 0)
                        .max()
                        .getAsInt();
        System.out.println(max);

        System.out.println("=====================");

        //Optional 클래스
        List<Integer> list = new ArrayList<>();

        /*double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();*/

        //방법1
        OptionalDouble optionalDouble = list.stream()
                .mapToInt(Integer::intValue)
                .average();

        if(optionalDouble.isPresent()) {
            System.out.println("평균 : " + optionalDouble.getAsDouble());
        } else {
            System.out.println("평균 : " + 0.0);
        }

        //방법2
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("평균 : " + avg);

        //방법3
        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(a -> System.out.println("평균 : " + a));   //값이 있다면 출력(값이 없으므로 출력안함)

        System.out.println("=====================");

        //Reduction(reduce)
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", "남성", 99),
                new Student("임꺽정", "남성", 95),
                new Student("이민정", "여성", 90),
                new Student("송혜교", "여성", 94),
                new Student("가나다", "남성", 88),
                new Student("라마바", "남성", 77)
        );

        int sum1 = studentList.stream()
                .mapToInt(Student::getScore)
                .sum();
        System.out.println("sum1 : " + sum1);

        int sum2 = studentList.stream()
                .mapToInt(Student::getScore)
                .reduce((a, b) -> a + b)
                .getAsInt();
        System.out.println("sum2 : " + sum2);

        int sum3 = studentList.stream()
                .mapToInt(Student::getScore)
                .reduce(0, (a, b) -> a + b);
        System.out.println("sum3 : " + sum3);
    }
}
