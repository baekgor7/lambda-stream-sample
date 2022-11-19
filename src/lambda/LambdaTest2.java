package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * 자바 8부터 표준 API로 제공되는 함수적 인터페이스 (java.util.function 패키지에 포함)
 * 매개타입으로 사용되어 람다식을 매개값으로 대입할 수 있도록 해준다.
 * Consumer 함수적 인터페이스류 (매개값 -> Consumer) : 매개값만 있고 리턴값이 없는 추상 메소드만 가지고 있다
 * Supplier 함수적 인터페이스류 (Supplier -> 리턴값) : 매개값은 없고 리턴값만 있는 추상 메소드만 가지고 있다
 * Function 함수적 인터페이스류 (매개값 -> Function -> 리턴값) : 주로 매개값을 리턴값으로 매핑(타입변환)할 경우에 사용
 * Operator 함수적 인터페이스류 (매개값 -> Operator -> 리턴값) : 주로 매개값을 연산하고 그 결과를 리턴할 경우에 사용
 * Predicate 함수적 인터페이스류 (매개값 -> Predicate -> boolean) : 매개값을 조사해서 true 또는 false를 리턴할 때 사용
 * */
public class LambdaTest2 {

    public static void main(String[] args) {

        //Consumer (내부 메소드인 .accept() 를 통해서 실행)
        Consumer<String> consumer = t -> {
            System.out.println(t + "8");
        };
        consumer.accept("java");

        BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + u);
        biConsumer.accept("java", "8");

        DoubleConsumer doubleConsumer = d -> System.out.println("java" + d);
        doubleConsumer.accept(8.0);

        ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t + i);
        objIntConsumer.accept("java", 8);

        System.out.println("=========================================================");

        //Supplier (내부 메소드인 .get() 혹은 타입에 따라 미리 정의된 .getXXX() 메소드를 통해 실행)
        Supplier<Integer> supplier = () -> {
            int num = (int) (Math.random() * 6) + 1;
            return num;
        };
        int num = supplier.get();
        System.out.println(num);

        System.out.println("=========================================================");

        //Function (내부 메소드인 .apply() 혹은 타입에 따라 정의된 .applyXXX() 메소드를 통해 실행)
        printString(t -> t.getName());
        printInt(t -> t.getEnglishScore());
        printInt(t -> t.getMathScore());
        System.out.println(avg(t -> t.getEnglishScore()));
        System.out.println(avg(t -> t.getMathScore()));

        System.out.println("=========================================================");

        //Operator (Function과 동일하게 .apply() 혹은 .applyXXX() 메소드를 통해 실행)
        int max = maxOrMin(
                (a, b) -> {
                    if(a >= b) return a;
                    else return b;
                }
        );
        System.out.println(max);

        int min = maxOrMin(
                (a, b) -> {
                    if(a < b) return a;
                    else return b;
                }
        );
        System.out.println(min);

        System.out.println("=========================================================");

        //Predicate (.test() 혹은 .testXXX() 메소드를 통하여 실행)
        double maleAvg = avg2(t -> t.getSex().equals("남성"));
        System.out.println(maleAvg);
        double femaleAvg = avg2(t -> t.getSex().equals("여성"));
        System.out.println(femaleAvg);

    }

    private static List<Student2> list2 = Arrays.asList(
            new Student2("홍길동", "남성", 95),
            new Student2("임꺽정", "남성", 99),
            new Student2("김순희", "여성", 98),
            new Student2("이효리", "여성", 91)
    );

    public static double avg2(Predicate<Student2> predicate) {
        int count = 0, sum = 0;
        for(Student2 student2 : list2) {
            if(predicate.test(student2)) {
                count++;
                sum += student2.getScore();
            }
        }
        return (double) sum / count;
    }

    private static int[] scores = {92, 95, 99};

    public static int maxOrMin(IntBinaryOperator operator) {
        int result = scores[0];
        for(int score : scores) {
            result = operator.applyAsInt(result, score);
        }
        return result;
    }

    private static List<Student> list = Arrays.asList(
        new Student("홍길동", 90, 95),
        new Student("임꺽정", 93, 99)
    );

    public static void printString(Function<Student, String> function) {
        for(Student student : list) {
            System.out.println(function.apply(student));
        }
    }

    public static void printInt(ToIntFunction<Student> function) {
        for(Student student : list) {
            System.out.println(function.applyAsInt(student));
        }
    }

    public static double avg(ToIntFunction<Student> function) {
        int sum = 0;
        for(Student student : list) {
            sum += function.applyAsInt(student);
        }
        double avg = (double) sum / list.size();
        return avg;
    }

}
