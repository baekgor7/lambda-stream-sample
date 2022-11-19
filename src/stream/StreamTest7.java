package stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest7 {

    public static void main(String[] args) {

        List<Student2> studentList = Arrays.asList(
                new Student2("홍길동", Student2.Sex.MALE, 99),
                new Student2("임꺽정", Student2.Sex.MALE, 95),
                new Student2("이민정", Student2.Sex.FEMALE, 90),
                new Student2("송혜교", Student2.Sex.FEMALE, 94),
                new Student2("가나다", Student2.Sex.MALE, 88),
                new Student2("라마바", Student2.Sex.MALE, 77)
        );

        //남학생들만 묶어 List 생성
        List<Student2> maleList = studentList.stream()
                .filter(s -> s.getSex() == Student2.Sex.MALE)
                .collect(Collectors.toList());

        maleList.stream().forEach(s -> System.out.println(s.getName()));

        System.out.println("=====================");

        //여학생들만 묶어 HashSet 생성
        Set<Student2> femaleSet = studentList.stream()
                .filter(s -> s.getSex() == Student2.Sex.FEMALE)
                .collect(Collectors.toCollection(HashSet::new));

        femaleSet.stream().forEach(s -> System.out.println(s.getName()));

        System.out.println("=====================");

        //사용자정의 컨테이너 수집하기
        MaleStudent maleStudent = studentList.stream()
                .filter(s -> s.getSex() == Student2.Sex.MALE)
                .collect(
                        () -> new MaleStudent(),
                        (r, t) -> r.accumulate(t),
                        (r1, r2) -> r1.combine(r2)
                );
        maleStudent.getList().stream()
                .forEach(s -> System.out.println(s.getName()));

        System.out.println("=====================");

        //요소를 그룹핑해서 수집
        List<Student2> totalList = Arrays.asList(
                new Student2("홍길동", Student2.Sex.MALE, 99, Student2.City.Seoul),
                new Student2("임꺽정", Student2.Sex.MALE, 95, Student2.City.Pusan),
                new Student2("이민정", Student2.Sex.FEMALE, 90, Student2.City.Seoul),
                new Student2("송혜교", Student2.Sex.FEMALE, 94, Student2.City.Seoul),
                new Student2("가나다", Student2.Sex.MALE, 88, Student2.City.Pusan),
                new Student2("라마바", Student2.Sex.MALE, 77, Student2.City.Pusan)
        );

        Map<Student2.Sex, List<Student2>> mapBySex = totalList.stream()
                .collect(Collectors.groupingBy(Student2::getSex));

        mapBySex.get(Student2.Sex.MALE).stream()
                .forEach(s -> System.out.println(s.getName()));

        System.out.println("=====================");

        mapBySex.get(Student2.Sex.FEMALE).stream()
                .forEach(s -> System.out.println(s.getName()));

        System.out.println("=====================");

        Map<Student2.City, List<String>> mapByCity = totalList.stream()
                .collect(
                        Collectors.groupingBy(
                                Student2::getCity,  //key값
                                Collectors.mapping(Student2::getName, Collectors.toList())  //담을 값, 담을 값 혀익
                        )
                );

        mapByCity.get(Student2.City.Seoul).stream()
                .forEach(System.out::println);

        System.out.println("=====================");

        //그룹핑 후 매핑 및 집계(리덕션)
        Map<Student2.Sex, Double> mapByS = totalList.stream()
                .collect(
                        Collectors.groupingBy(
                                Student2::getSex,
                                Collectors.averagingDouble(Student2::getScore)
                        )
                );
        System.out.println("남성 평균 점수 : " + mapByS.get(Student2.Sex.MALE));
        System.out.println("여성 평균 점수 : " + mapByS.get(Student2.Sex.FEMALE));

        System.out.println("=====================");

        Map<Student2.Sex, String> mapByN = totalList.stream()
                .collect(
                        Collectors.groupingBy(
                                Student2::getSex,
                                Collectors.mapping(
                                        Student2::getName,
                                        Collectors.joining(",")
                                )
                        )
                );
        System.out.println("남성 평균 점수 : " + mapByN.get(Student2.Sex.MALE));
        System.out.println("여성 평균 점수 : " + mapByN.get(Student2.Sex.FEMALE));

    }
}
