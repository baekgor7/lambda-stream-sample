package stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest8 {

    public static void main(String[] args) {

        List<Student2> studentList = Arrays.asList(
                new Student2("홍길동", Student2.Sex.MALE, 99),
                new Student2("임꺽정", Student2.Sex.MALE, 95),
                new Student2("이민정", Student2.Sex.FEMALE, 90),
                new Student2("송혜교", Student2.Sex.FEMALE, 94),
                new Student2("가나다", Student2.Sex.MALE, 88),
                new Student2("라마바", Student2.Sex.MALE, 77)
        );

        //병렬 스트림
        MaleStudent maleStudent = studentList.parallelStream()
                .collect(
                        () -> new MaleStudent(),
                        (r, t) -> r.accumulate(t),
                        (r1, r2) -> r1.combine(r2)
                );
        maleStudent.getList().stream()
                .forEach(s -> System.out.println(s.getName()));

        System.out.println("=====================");

    }
}
