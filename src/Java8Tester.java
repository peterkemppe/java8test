import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Map;

public class Java8Tester {

    public static void main(String args[]) {
        Java8Tester tester = new Java8Tester();

        //with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        //with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        //with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        //without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        //without parenthesis
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        //with parenthesis
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");

        ShoutOutLoad shout1 = message -> System.out.println(message.toUpperCase());
        ShoutOutLoad shout2 = message -> System.out.println(message.toLowerCase());

        shout1.shoutMessage("scream");
        shout2.shoutMessage("WHISPER");

        List<String> names = new ArrayList<String>();
        List<String> names2 = Arrays.asList("Peter", "Kemppe", "Moggebigge", "Kallejalle", "Turelure");
        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        names.forEach(System.out::println);
        names2.forEach(System.out::println);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("Print numbers greater than 3:");
        eval(list, n-> n > 3 );

        System.out.println("Print all numbers:");

        eval(list, n->true);

        System.out.println("Print even numbers:");
        eval(list, n-> n%2 == 0 );
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    interface ShoutOutLoad {
        void shoutMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {

        for(Integer n: list){
            if(predicate.test(n)){
                System.out.println(n + " ");
            }
        }
    }
}