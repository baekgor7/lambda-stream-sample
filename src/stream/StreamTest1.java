package stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("홍길동", "임꺽정", "김희선");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        System.out.println("==========================================");

        Stream<String> stream = list.stream();
        stream.forEach(name -> System.out.println(name));

        System.out.println("==========================================");

        Stream<Student> studentStream = list2.stream();

        /*studentStream.forEach(s -> {
            System.out.println(s.getName() + ", " + s.getScore());
        });*/
        studentStream.map(s -> s.getName()).forEach(
                System.out::println
        );

        System.out.println("==========================================");

        //stream은 두번 사용이 불가
        //double avg = studentStream.mapToInt(student -> student.getScore()).average().getAsDouble();
        double avg = list2.stream().mapToInt(Student::getScore).average().getAsDouble();
        System.out.println(avg);

    }

    private static List<Student> list2 = Arrays.asList(
            new Student("홍길동", "남성", 99),
            new Student("임꺽정", "남성", 95),
            new Student("이민정", "여성", 90)
    );


}
