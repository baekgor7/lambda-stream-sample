package stream;

import java.util.*;
import java.util.stream.IntStream;

public class StreamTest4 {

    public static void main(String[] args) {

        //flatMapXXX
        List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");

        inputList1.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .forEach(word -> System.out.println(word));

        List<String> inputList2 = Arrays.asList("10,20,30", "40,50,60");
        inputList2.stream()
                .flatMapToInt(n -> {
                    String[] strArray = n.split(",");
                    int[] intArr = new int[strArray.length];
                    for(int i=0; i < strArray.length; i++) {
                        intArr[i] = Integer.parseInt(strArray[i].trim());
                    }
                    return Arrays.stream(intArr);
                })
                .forEach(number -> System.out.println(number));

        //MapXXX
        list.stream()
            .mapToInt(Student::getScore)
            .forEach(System.out::println);

        StreamTest4 st4 = new StreamTest4();
        st4.list2().stream()
                .mapToInt(s -> s.getScore())
                .forEach(System.out::println);

        //
        int[] intArray = {1, 2, 3, 4, 5};

        IntStream intStream = Arrays.stream(intArray);
        intStream.asDoubleStream()
                .forEach(d -> System.out.println(d));
    }

    private static List<Student> list = Arrays.asList(
            new Student("홍길동", "남성", 99),
            new Student("임꺽정", "남성", 95),
            new Student("이민정", "여성", 90),
            new Student("송혜교", "여성", 94)
    );

    public List<Student> list2() {

        List<Student> list = Arrays.asList(
            new Student("가나다", "남성", 88),
            new Student("라마바", "남성", 77)
        );

        return list;
    }
}
