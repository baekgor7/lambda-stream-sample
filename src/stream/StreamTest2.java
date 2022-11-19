package stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2 {

    public static void main(String[] args) throws Exception {

        //람다식으로 스트림 생성
        Stream<Integer> stream = Stream.iterate(0, n -> n + 1).limit(10);
        stream.forEach(System.out::println);

        //Collection으로부터 스트림 얻기
        Stream<Student> studentStream = list.stream();
        studentStream.forEach(s -> System.out.println(s.getName()));

        //배열로부터 스트림 얻기
        String[] strArray = {"가","나","다"};
        Stream<String> strStream = Arrays.stream(strArray);
        strStream.forEach(s -> System.out.println(s));

        int[] intArray = {10, 11, 12};
        IntStream intStream = Arrays.stream(intArray);
        intStream.forEach(System.out::println);

        //숫자범위로부터 스트림 얻기
        IntStream rangeStream = IntStream.rangeClosed(1, 100);
        rangeStream.forEach(n -> sum += n);
        System.out.println(sum);

        //파일로부터 스트림 얻기(1)
        Path path = Paths.get("src/text");
        Stream<String> fileStream;

        fileStream = Files.lines(path, Charset.defaultCharset());
        fileStream.forEach(System.out::println);
        fileStream.close();

        //파일로부터 스트림 얻기(2) : BufferedReader의 lines() 메소드 이용
        File f = path.toFile();
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        fileStream = br.lines();
        fileStream.forEach(System.out::println);
        fileStream.close();

        //디렉토리로부터 스트림 얻기
        Path p = Paths.get("C:/workspace-sle/java-temp/src/stream");
        Stream<Path> pathStream = Files.list(p);
        pathStream.forEach(pp -> System.out.println(pp.getFileName()));
    }

    private static int sum;

    private static List<Student> list = Arrays.asList(
            new Student("홍길동", "남성", 99),
            new Student("임꺽정", "남성", 95),
            new Student("이민정", "여성", 90),
            new Student("송혜교", "여성", 94)
    );
}
