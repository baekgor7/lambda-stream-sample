package lambda;

public class LambdaTest1 {

    public static void main(String[] args) {

        MyFunctionalInterface fi;

        fi = () -> {
            String str = "method call1";
            System.out.println(str);
        };
        fi.method();

        fi = () -> { System.out.println("method call2"); };
        fi.method();

        fi = () -> System.out.println("method call3");
        fi.method();

        fi = new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("method call4");
            }
        };
        fi.method();

        MyFunctionalInterface2 fi2;

        fi2 = (x) -> {
            int result = x * 5;
            System.out.println(result);
        };
        fi2.method(2);

        fi2 = (x) -> { System.out.println(x * 5); };
        fi2.method(3);

        fi2 = x -> System.out.println(x * 7);
        fi2.method(4);


        MyFunctionalInterface3 fi3;

        fi3 = (x, y) -> {
            int result = x + y;
            return result;
        };
        System.out.println(fi3.method(2, 5));

        fi3 = (x, y) -> { return x + y; };
        System.out.println(fi3.method(2, 6));

        fi3 = (x, y) -> x + y;
        System.out.println(fi3.method(2, 8));

        fi3 = (x, y) -> {
            return sum(x, y);
        };
        System.out.println(fi3.method(2, 8));

    }

    public static int sum(int x, int y) {
        return (x + y);
    }
}
